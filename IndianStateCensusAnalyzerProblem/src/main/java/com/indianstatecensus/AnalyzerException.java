package com.indianstatecensus;

public class AnalyzerException extends Exception{
    enum ExceptionType{
        FILE_NOT_FOUND, NOT_A_CSV_TYPE, UNABLE_TO_PARSE
    }

    ExceptionType type;

    public AnalyzerException(ExceptionType type, String msg){
        super(msg);
        this.type =type;
    }
}
