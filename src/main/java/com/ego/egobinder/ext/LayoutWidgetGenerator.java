package com.ego.egobinder.ext;

import com.ego.egobinder.layout.annotation.EgoEntity;
import com.ego.egobinder.layout.annotation.EgoField;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JPackage;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Oliver
 * @since 12.11.12 22:58
 */
public class LayoutWidgetGenerator extends Generator
{
    @Override
    public String generate(TreeLogger logger, GeneratorContext context,
                           String requestedClass) throws UnableToCompleteException
    {
        TypeOracle typeOracle = context.getTypeOracle();
        assert (typeOracle != null);

        JClassType classType = typeOracle.findType(requestedClass);
        if (classType == null) {
            logger.log(TreeLogger.ERROR, "Unable to find metadata for type '"
                    + requestedClass + "'", null);
            throw new UnableToCompleteException();
        }

        if (classType.isInterface() == null) {
            logger.log(TreeLogger.ERROR, classType.getQualifiedSourceName()
                    + " is not an interface", null);
            throw new UnableToCompleteException();
        }

        JPackage jPackage = classType.getPackage();
        PrintWriter pw = context.tryCreate(logger,
                jPackage.getName(), classType.getName()+"Impl");
        if (pw != null)
        {
            pw.println(createHead(jPackage.getName(), classType.getName()));
            pw.println(createMethodImpl());
            pw.println(createAutoLayoutCode());
            pw.println("}");
            pw.println("}");
            context.commit(logger, pw);
        }

        return jPackage.getName()+"."+classType.getName()+"Impl";
    }

    private StringBuffer createHead(String packageName, String interfaceName)
    {
        StringBuffer head = new StringBuffer();
        head.append("package ").append(packageName).append(";");
        head.append("\n");
        head.append(createImports());
        head.append("\n");
        head.append("public class ").append(interfaceName).append("Impl implements ").append(interfaceName);
        head.append("\n").append("{\n");
        return head;
    }

    private StringBuffer createImports()
    {
        StringBuffer imports = new StringBuffer();
        imports.append("import com.google.gwt.user.client.ui.*;\n");
        return imports;
    }

    private StringBuffer createMethodImpl()
    {
        StringBuffer methodImpl = new StringBuffer();
        methodImpl.append("@Override\n");
        methodImpl.append("public Widget asWidget()");
        methodImpl.append("\n").append("{");
        return methodImpl;
    }

    private StringBuffer createAutoLayoutCode()
    {
        StringBuffer autoLayoutCode = new StringBuffer();
        autoLayoutCode.append("VerticalPanel myPanelContent = new VerticalPanel();\n");

        Reflections reflections = new Reflections("com.ego.egobinder.client.uibo");

        Set<Class<?>> annotated =
                reflections.getTypesAnnotatedWith(EgoEntity.class);

        if (annotated != null && !annotated.isEmpty())
        {
            for (Class<?> clazz : annotated)
            {
                EgoEntity egoEntity = clazz.getAnnotation(EgoEntity.class);
                String egoEntityName = egoEntity.name().toLowerCase();
                autoLayoutCode.append("DialogBox ")
                        .append(egoEntityName)
                        .append(" = new DialogBox(true, false, new EgoCaption(\"")
                        .append(egoEntityName)
                        .append("\"));\n");
                autoLayoutCode.append("FlowPanel ").append(egoEntityName).append("FlowPanel = new FlowPanel();\n");

                Method[] methods = clazz.getMethods();
                Set<Method> annotatedMethods = null;

                if (methods!=null && methods.length>0)
                {
                    annotatedMethods = new HashSet<Method>();
                    for (Method method : methods)
                    {
                        if (method.isAnnotationPresent(EgoField.class))
                        {
                            annotatedMethods.add(method);
                        }
                    }
                }
//                reflections = new Reflections(new Object[] {clazz}, new MethodAnnotationsScanner());

//                Set<Method> annotatedMethods = reflections.getMethodsAnnotatedWith(EgoField.class);

                if (annotatedMethods!=null && !annotatedMethods.isEmpty())
                {
                    for (Method annotatedMethod: annotatedMethods)
                    {
                        EgoField egoField = annotatedMethod.getAnnotation(EgoField.class);
                        autoLayoutCode.append(egoEntityName).append("FlowPanel.add(new Label(");
                        autoLayoutCode.append("\"").append(egoField.name()).append("\"");
                        autoLayoutCode.append("));\n");

                        autoLayoutCode.append("try\n");
                        autoLayoutCode.append("{\n");
                        autoLayoutCode.append("Widget widget = new ");
                        autoLayoutCode.append(egoField.uiClass().getName()).append("();\n");
                        autoLayoutCode.append(egoEntityName).append("FlowPanel.add(widget);\n");
                        autoLayoutCode.append("} catch (Exception e)\n");
                        autoLayoutCode.append("{\n");
                        autoLayoutCode.append(egoEntityName).append("FlowPanel.add(new Label(\"Could not create or add: ["+egoField.uiClass().getName()+"]\"));\n");
                        autoLayoutCode.append("}\n");

                    }
                }

                autoLayoutCode.append(egoEntityName).append(".add(").append(egoEntityName).append("FlowPanel);");
                autoLayoutCode.append("myPanelContent.add(").append(egoEntityName).append(");");
                autoLayoutCode.append("\n\n");

            }
        }
        autoLayoutCode.append("return myPanelContent;\n");
        return autoLayoutCode;
    }

}
