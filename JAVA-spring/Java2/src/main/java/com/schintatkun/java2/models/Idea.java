package com.schintatkun.java2.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;



@Entity
@Table(name="ideas")
public class Idea {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@Size(min=1, message="Content must not be empty")
	private String content;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
	// many to one : many ideas can be created by a user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
	
    // many to one : many tasks can be assigned to same assignee (a users can have many tasks)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="like_id")
//    private User like;
	
    @ManyToMany
	@JoinTable(
			name = "users_ideas",
	        joinColumns = @JoinColumn(name="idea_id"),
	        inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> liked_byusers;
    
    public Idea() {}
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getLiked_byusers() {
		return liked_byusers;
	}

	public void setLiked_byusers(List<User> liked_byusers) {
		this.liked_byusers = liked_byusers;
	}

	
}
