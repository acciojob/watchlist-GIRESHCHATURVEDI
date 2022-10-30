package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.MovieServicegetName(name), HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMoviesService(),HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.DirecterSeviceName(name), HttpStatus.OK);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        return new ResponseEntity<>(movieService.DirectorNmaeService(director),HttpStatus.OK);
    }
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movie){
        movieService.MovieServiceAdditon(movie);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){
        movieService.DirectorServiceAddition(director);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                               @RequestParam("directorName") String directorName){
        try {
            movieService.ServicePair(movieName,directorName);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
        try {
            movieService.deleteReport(directorName);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping ("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        try {
            movieService.AllServiceDElete();
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
