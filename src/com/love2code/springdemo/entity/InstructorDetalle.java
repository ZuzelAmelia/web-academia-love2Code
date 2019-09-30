package com.love2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detalle")
public class InstructorDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "canal_youtube")
	private String canalYoutube;

	@Column(name = "hobby")
	private String hobby;

	public InstructorDetalle() {

	}

	public InstructorDetalle(String canalYoutube, String hobby) {
		this.canalYoutube = canalYoutube;
		this.hobby = hobby;
	}

	public String getCanalYoutube() {
		return canalYoutube;
	}

	public void setCanalYoutube(String canalYoutube) {
		this.canalYoutube = canalYoutube;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetalle [id=" + id + ", canalYoutube=" + canalYoutube + ", hobby=" + hobby + "]";
	}

}
