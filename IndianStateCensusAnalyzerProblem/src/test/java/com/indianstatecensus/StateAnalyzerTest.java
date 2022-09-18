package com.indianstatecensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateAnalyzerTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\RFP-175\\Indian-State-Census-Analyser-Problem\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/CensusData.csv";
    private static final String WRONG_CSV_TYPE = "./src/main/resources/IndiaStateCensusData.txt";
    private static final String SAMPLE_CSV_DELIMITERS = "./src/main/resources/IndiaStateCensusDataIncorrectDelimeter.csv";
    private static final String SAMPLE_CSV_HEADER = "./src/main/resources/IndiaStateCensusDataIncorrectHeader.csv";


    private static final String STATE_CODE_CSV_FILE_PATH = "D:\\RFP-175\\Indian-State-Census-Analyser-Problem\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndianStateCode.csv";
    private static final String WRONG_STATE_CSV_FILE_PATH = "./src/main/resources/Code.csv";
    private static final String WRONG_STATE_CSV_TYPE = "./src/main/resources/IndiaStateCode.txt";
    private static final String SAMPLE_STATE_CODE_DELIMITER = "./src/main/resources/IndiaStateCodeIncorrectDelimeter.csv";
    private static final String SAMPLE_STATE_CODE_HEADER = "./src/main/resources/IndiaStateCodeIncorrectHeader.csv";


    StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();


    @Test
    public void givenIndianCensusCSVFile_ReturnsCorrectRecords() throws AnalyzerException {
        int numOfRecords = stateCensusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
        Assertions.assertEquals(29, numOfRecords);
    }

    @Test
    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (AnalyzerException e) {
            Assertions.assertEquals(AnalyzerException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }
    @Test
    public void  givenIndiaCensusData_WhenWrongType_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaCensusData(WRONG_CSV_TYPE);
        } catch (AnalyzerException e){
            Assertions.assertEquals(AnalyzerException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WhenDelimiterIncorrect_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaCensusData(SAMPLE_CSV_DELIMITERS);
        } catch (AnalyzerException e) {
            Assertions.assertEquals(AnalyzerException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
    @Test
    public void givenIndiaCensusData_WhenHeaderIncorrect_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaCensusData(SAMPLE_CSV_HEADER);
        } catch (AnalyzerException e){
            Assertions.assertEquals(AnalyzerException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }

    //Test CASES for State Codes

    @Test
    public void given_IndianStateCodeCSVFile_ReturnsCorrectRecords() throws AnalyzerException {
        int numOfRecords = stateCensusAnalyzer.loadIndiaStateCode(STATE_CODE_CSV_FILE_PATH);
        System.out.println(numOfRecords);
        Assertions.assertEquals(37, numOfRecords);
    }

    @Test
    public void givenIndiaStateCodeData_WithWrongFile_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaStateCode(WRONG_STATE_CSV_FILE_PATH);
        } catch (AnalyzerException e) {
            Assertions.assertEquals(AnalyzerException.ExceptionType.FILE_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenWrongType_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaStateCode(WRONG_STATE_CSV_TYPE);
        } catch (AnalyzerException e){
            Assertions.assertEquals(AnalyzerException.ExceptionType.NOT_A_CSV_TYPE, e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenDelimiterIncorrect_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaStateCode(SAMPLE_STATE_CODE_DELIMITER);
        } catch (AnalyzerException e) {
            Assertions.assertEquals(AnalyzerException.ExceptionType.UNABLE_TO_PARSE , e.type);
        }
    }

    @Test
    public void givenIndiaStateCodeData_WhenHeaderIncorrect_ShouldThrowException() {
        try {
            stateCensusAnalyzer.loadIndiaStateCode(SAMPLE_STATE_CODE_HEADER);
        } catch (AnalyzerException e){
            Assertions.assertEquals(AnalyzerException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
}
