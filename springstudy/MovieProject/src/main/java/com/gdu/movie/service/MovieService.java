package com.gdu.movie.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.gdu.movie.domain.MovieDTO;

public interface MovieService {
	public List<MovieDTO> getAllMovies();
	
	public Map<String, Object> searchMovie(MovieDTO movie);
	
	public void movieCount(Model model);
	
	
}
