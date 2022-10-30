package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    //movie
    public void MovieServiceAdditon(Movie movie) {
        movieRepository.MovieReportAdditon(movie);
    }


    public Movie MovieServicegetName(String name) {

        return movieRepository.MovieNameReport(name);
    }


    public List<String> findAllMoviesService() {
        return movieRepository.finalMoviesReport();
    }

    public void DirectorServiceAddition(Director director) {
        movieRepository.DirectorReportAdditon(director);
    }


    //Director
    public Director DirecterSeviceName(String name) {
        return movieRepository.directorNamereport(name);
    }



    public void ServicePair(String movieName, String directorName) {
        movieRepository.moviePairAdd(movieName, directorName);
    }


    public List<String> DirectorNmaeService(String directorName) {
        return movieRepository.moviesget(directorName);
    }


    public void deleteReport(String directorName) {
        movieRepository.deleteReport(directorName);
    }


    public void AllServiceDElete() {
        movieRepository.AllreportDElete();
    }
}
