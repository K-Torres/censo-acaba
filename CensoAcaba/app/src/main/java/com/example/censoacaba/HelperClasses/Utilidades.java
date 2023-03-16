package com.example.censoacaba.HelperClasses;

public class Utilidades {
    

    //Constantes campos tabla usuario

    public static final String TABLA_USUARIO ="usuario";
    public static final String CAMPO_ID = "ID";
    public static final String CAMPO_NOMBRE = "NOMBRES";
    public static final String CAMPO_PRIMER_APELLIDO = "PRIMER_APELLIDO";
    public static final String CAMPO_SEGUNDO_APELLIDO = "SEGUNDO_APELLIDO";
    public static final String CAMPO_CORREO = "CORREO";
    public static final String CAMPO_GENERO = "GENERO";
    public static final String CAMPO_TELEFONO = "TELEFONO";
    public static final String CAMPO_FECHA_NACIMIENTO = "FECHA_NACIMIENTO";
    public static final String CAMPO_TIPO_DOCUMENTO = "TIPO_DOCUMENTO";
    public static final String CAMPO_NUMERO_DOCUMENTO = "NUM_DOCUMENTO_IDENTIDAD";
    public static final String CAMPO_FECHA_EXPEDICION = "FECHA_EXPEDICION";
    public static final String CAMPO_DEPARTAMENTO = "DEPARTAMENTO";
    public static final String CAMPO_MUNICIPIO = "MUNICIPIO";
    public static final String CAMPO_CONSEJO = "CONSEJO";
    public static final String CAMPO_COMUNIDAD = "COMUNIDAD";
    public static final String CAMPO_TRONCO_FAMILIAR = "TRONCO_FAMILIAR";
    public static final String CAMPO_ID_FAMILIAR = "ID_FAMILIAR";
    public static final String CAMPO_PERMANENCIA_TERRITORIAL = "PERMANENCIA_TERRITORIAL";
    public static final String CAMPO_PARENTESCO = "PARENTESCO";
    public static final String CAMPO_CABEZA_FAMILIA = "CABEZA_FAMILIA";
    public static final String CAMPO_ETNIA = "ETNIA";
    public static final String CAMPO_TIPO_SANGRE = "TIPO_SANGRE";
    public static final String CAMPO_NIVEL_ESCOLAR = "ESCOLARIDAD";
    public static final String CAMPO_DISCAPACIDAD = "TIPO_DISCAPACIDAD";
    public static final String CAMPO_TIPO_VICTIMA = "TIPO_VICTIMA";
    public static final String CAMPO_EPS = "EPS";
    public static final String CAMPO_STATUS = "STATUS";


    public static final String CREAR_TABLA_USUARIO= "CREATE TABLE " +
            TABLA_USUARIO + " ("+CAMPO_ID+" INTEGER, " + CAMPO_NOMBRE+" TEXT,  "+
            CAMPO_PRIMER_APELLIDO+" TEXT, "+CAMPO_SEGUNDO_APELLIDO+" TEXT, "+
            CAMPO_CORREO+" TEXT , "+CAMPO_TELEFONO+" TEXT , "+CAMPO_GENERO+" TEXT, "
            +CAMPO_FECHA_NACIMIENTO+" TEXT, "+CAMPO_TIPO_DOCUMENTO+" TEXT, "+
            CAMPO_NUMERO_DOCUMENTO+" TEXT, "+CAMPO_FECHA_EXPEDICION+" TEXT, "+
            CAMPO_DEPARTAMENTO+" TEXT, "+CAMPO_MUNICIPIO+" TEXT, "+CAMPO_CONSEJO
            +" TEXT, "+CAMPO_COMUNIDAD+" TEXT, "+CAMPO_TRONCO_FAMILIAR+" INTEGER, "+
            CAMPO_ID_FAMILIAR+" INTEGER, "+CAMPO_PERMANENCIA_TERRITORIAL+" TEXT, "+
            CAMPO_PARENTESCO+" TEXT, "+CAMPO_CABEZA_FAMILIA+" TEXT, "+CAMPO_ETNIA+
            " TEXT, "+CAMPO_TIPO_SANGRE+" TEXT, "+CAMPO_NIVEL_ESCOLAR+" TEXT, "+
            CAMPO_DISCAPACIDAD+" TEXT, "+CAMPO_TIPO_VICTIMA+" TEXT, "+CAMPO_EPS+" TEXT,"+CAMPO_STATUS+" INTEGER)";

}
