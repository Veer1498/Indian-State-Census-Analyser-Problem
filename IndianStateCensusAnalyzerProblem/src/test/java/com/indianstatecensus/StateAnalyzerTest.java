package com.indianstatecensus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateAnalyzerTest {

    private static final String INDIA_CENSUS_CSV_FILE_PATH = "D:\\RFP-175\\Indian-State-Census-Analyser-Problem\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndianStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/CensusData.csv";
    private static final String WRONG_CSV_TYPE = "./src/main/resources/IndiaStateCensusData.txt";
    private static final String SAMPLE_CSV_DELIMITERS = "./src/main/resources/IndiaStateCensusDataIncorrectDelimeter.csv";
    private static final String SAMPLE_CSV_HEADER = "./src/main/resources/IndiaStateCensusDataIncorrectHeader.csv";

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
}
