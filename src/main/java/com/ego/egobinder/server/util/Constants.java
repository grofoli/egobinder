package com.ego.egobinder.server.util;

import java.util.TimeZone;

public class Constants {
    private final static String BASE_DIR_PATH = "C:\\Prt";
    private final static String BASE_DIR_PROPERTY = "base.dir.path";
    public final static String PROCESSING_DIR = "_capture";
    public final static String PRT_EXTENSION = "prt";
    public final static int PORT = 9100;

    public final static String PDF_EXTENSION = "pdf";
    public final static String PDF_DIRECTORY = "Pdfs";
    public final static String PCL_DIRECTORY = "Pcls";
    public final static String PATH_SEPARATOR = "\\";

    public final static String EXECUTABlE_DIR = "_bin";
    public final static String PCL_TO_PDF_COMMAND = "WinPCLtoPDF";
    public final static String PDF_ROTATION_COMMAND = "pdftk";

    public static TimeZone UTC = TimeZone.getTimeZone("UTC");
    public static TimeZone UTC_PLUS_ONE = TimeZone.getTimeZone("Europe/Berlin");

    public static String getBaseDirectory() {
        String baseDirectory = System.getProperty(BASE_DIR_PROPERTY);
        if (baseDirectory == null) {
            baseDirectory = BASE_DIR_PATH;
        }
        return baseDirectory + PATH_SEPARATOR;
    }
}
