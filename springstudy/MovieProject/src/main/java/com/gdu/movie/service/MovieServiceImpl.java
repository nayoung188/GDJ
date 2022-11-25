package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public List<MovieDTO> getAllMovies() {
		return movieMapper.selectAllMovies();
	}
	
	@Override
	public Map<String, Object> searchMovie(MovieDTO movie) {
		int no = movie.getNo();
		String title = movie.getTitle();
		String genre = movie.getGenre();
		String description = movie.getDescription();
		int star = movie.getStar();
		
		MovieDTO movies = MovieDTO.builder()
				.No(no)
				.title(title)
				.genre(genre)
				.description(description)
				.star(star)
				.build();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("movies", movies);
	
		return map;
	}
	
	
	@Override
	public void movieCount(Model model) {
		int totalRecord = movieMapper.selectAllMoviesCount();
		model.addAttribute("totalRecord", totalRecord);
	}
	
}
