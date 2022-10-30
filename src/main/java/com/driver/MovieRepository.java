package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    //movie
    HashMap<String, Movie> movieMap = new HashMap<>();

    public void MovieReportAdditon(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public Movie MovieNameReport(String name) {
        try {
            Movie curr = movieMap.get(name);
            return curr;
        } catch (Exception e) {
            return null;
        }
    }
    public List<String> finalMoviesReport () {
        List<String> list = new ArrayList<>();
        for (String movie : movieMap.keySet()
        ) {
            list.add(movie);

        }
        return list;
    }
    public void movieDelete (String name){
        movieMap.remove(name);
    }

    //director
    HashMap<String, Director> directorHm=new HashMap<>();

    public void DirectorReportAdditon(Director director){
        directorHm.put(director.getName(),director);
    }


    public Director directorNamereport(String name) {
        try {
            Director curr=directorHm.get(name);
            return curr;
        }
        catch (Exception e){
            return null;
        }

    }





    public void deleteDirector(String directorName) {
        directorHm.remove(directorName);
    }

    //pair
    HashMap<String,List<String>> pairHm=new HashMap<>();



    public void moviePairAdd(String movieName, String directorName) {
        List<String> movieList;
        if(pairHm.containsKey(directorName)){
            movieList = pairHm.get(directorName);
        }
        else {
            movieList = new ArrayList<>();

        }
        movieList.add(movieName);
        pairHm.put(directorName,movieList);

    }


    public List<String> moviesget(String directorName) {
        if(pairHm.containsKey(directorName)) {
            for (String curr : pairHm.keySet()) {
                if (curr.equals(directorName)) {

                    return pairHm.get(curr);
                }
            }
        }
        return null;
    }


    public void deleteReport(String directorName) {

        if(pairHm.containsKey(directorName)){

            List<String> movieList=pairHm.get(directorName);
            for (String name:movieList
            ) {
                deleteReport(name);
            }

            deleteDirector(directorName);
            pairHm.remove(directorName);
        }


    }


    public void AllreportDElete() {
        if(!pairHm.isEmpty()){
            for (String name:pairHm.keySet()){

                deleteReport(name);

            }

            pairHm.clear();
        }

    }
}
