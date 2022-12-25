package com.roommate.matching.RoommateMatching.api.user.v1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "userPreferredLocation")
public class UserPreferredLocationItem {
    @Id
    @GeneratedValue()
    @Column(name = "userPreferredLocationId", nullable = false, updatable = false)
    private Long userPreferredLocationId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk", nullable = false)
    private UserItem user;

    @Column(name = "location")
    private String location;

    public Long getId() {
		return userPreferredLocationId;
	}

	public void setId(final Long userPreferredLocationId) {
		this.userPreferredLocationId = userPreferredLocationId;
	}

    public UserItem getUser() {
		return user;
	}

	public void setUser(final UserItem user) {
		this.user = user;
	}

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    @Override
	public String toString() {
		return Stream.of(String.valueOf(userPreferredLocationId), user.toString(), location).collect(Collectors.joining("-"));
	}
}
