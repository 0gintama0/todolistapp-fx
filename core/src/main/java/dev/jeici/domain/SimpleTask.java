package dev.jeici.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public
class SimpleTask
{
	private String id;
	private String name;
	private String description;
	private String owner;
	private Date   creationDate;
	private Date   deadDate;
}
