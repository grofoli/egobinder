package com.ego.egobinder.client.uibo;

import com.ego.egobinder.shared.model.Department;
import com.ego.egobinder.layout.annotation.DomainType;
import com.ego.egobinder.layout.annotation.EgoEntity;
import com.ego.egobinder.layout.annotation.EgoField;
import com.google.gwt.user.client.ui.TextArea;

/**
 * @author Oliver
 * @since 09.11.12 21:02
 */
@EgoEntity(
        name="Department")
public class DepartmentUIBO implements Department
{
    private String code;
    private String longDesc;

    @EgoField(
            name="code",
            domainType = DomainType.CODE_SHORT,
            mandatory = true)
    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    @EgoField(
            name="longDesc",
            domainType = DomainType.CODE_LONG,
            uiClass = TextArea.class,
            mandatory = true)
    public String getLongDesc()
    {
        return longDesc;
    }

    public void setLongDesc(String longDesc)
    {
        this.longDesc = longDesc;
    }

    @Override
    public String toString()
    {
        return "DepartmentUIBO{" +
                "code='" + code + '\'' +
                '}';
    }
}
