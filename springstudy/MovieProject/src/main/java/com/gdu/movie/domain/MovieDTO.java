package com.gdu.movie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
	private int No;
	private String title;
	private String genre;
	private String description;
	private int star;
	
}
