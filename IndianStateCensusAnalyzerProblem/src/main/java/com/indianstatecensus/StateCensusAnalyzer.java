package com.indianstatecensus;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

    public class StateCensusAnalyzer {
        public int loadIndiaCensusData(String csvFilePath) throws AnalyzerException {
            if (!getFileExtension(csvFilePath).equals(".csv"))
                throw new AnalyzerException(AnalyzerException.ExceptionType.NOT_A_CSV_TYPE,"Wrong file type");
            try {
                Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
                CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(CSVStateCensus.class);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
                Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();;
                int namOfEateries = 0;
                while (censusCSVIterator.hasNext()) {
                    namOfEateries++;
                    CSVStateCensus censusData = censusCSVIterator.next();
                }
                return namOfEateries;
            }catch (IOException exception) {
                System.out.println("IO Exception "+ exception.getMessage());
                throw new AnalyzerException(AnalyzerException.ExceptionType.FILE_NOT_FOUND,"File not found!");
            }catch (Exception exception){
                System.out.println("Exception "+ exception.getMessage());
                throw new AnalyzerException(AnalyzerException.ExceptionType.UNABLE_TO_PARSE,"Wrong delimiter or header");
            }
        }

        private static String getFileExtension(String file) {
            String extension = "";
            try {
                if (file != null) {
                    extension = file.substring(file.lastIndexOf("."));
                }
            } catch (Exception e) {
                extension = "";
            }
            return extension;
        }
    }
