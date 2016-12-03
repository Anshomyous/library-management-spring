package edu.sjsu.cmpe275.lms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@Entity
@Table(name = "BOOK")
public class Book {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "BOOK_ID", length = 8, unique = true, nullable = false)
	private Integer bookId;
		@Column(name = "ISBN", nullable = false,unique=true)
	private String isbn;
	@Column(name = "AUTHOR", nullable = false)
	private String author;
	@Column(name = "TITLE", nullable = false, unique = true)
	private String title;
	@Column(name = "CALLNUMBER", length = 10)
	private String callnumber;
	@Column(name = "PUBLISHER", nullable = false)
	private String publisher;
	@Column(name = "YEAR_OF_PUBLICATION")
	private int year_of_publication;
	/**
	 * Location of the book in library
	 */
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "NUM_OF_COPIES")
	private int num_of_copies;
	@Column(name = "CURRENT_STATUS")
	private String current_status;
	@Column(name = "KEYWORDS")
	private String keywords;
	@Column(name = "IMAGE")
	private byte[] image;

	// waitlist
	@Autowired
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable
	(
			name="USER_BOOK_WAITLIST",
			joinColumns={ @JoinColumn(name="BOOK_ID", referencedColumnName="BOOK_ID") },
			inverseJoinColumns={ @JoinColumn(name="USER_ID", referencedColumnName="USER_ID", unique=true) }
			)
	List<User> waitlist = new ArrayList<User>();

	//current users having the book
	/*@Autowired
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable
	(
			name="USER_BOOK",
			joinColumns={ @JoinColumn(name="ISBN", referencedColumnName="ISBN") },
			inverseJoinColumns={ @JoinColumn(name="ID", referencedColumnName="ID", unique=true) }
			)*/
	@OneToMany(mappedBy="book")
	List<UserBook> currentUsers = new ArrayList<UserBook>();


	public Book() {
	}

	public Book(String isbn, String author, String title, String callnumber, String publisher, int year_of_publication, String location, int num_of_copies, String current_status, String keywords, byte[] image) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.callnumber = callnumber;
		this.publisher = publisher;
		this.year_of_publication = year_of_publication;
		this.location = location;
		this.num_of_copies = num_of_copies;
		this.current_status = current_status;
		this.keywords = keywords;
		this.image = image;

	}

	/**
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCallnumber() {
		return callnumber;
	}

	public void setCallnumber(String callnumber) {
		this.callnumber = callnumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNum_of_copies() {
		return num_of_copies;
	}

	public void setNum_of_copies(int num_of_copies) {
		this.num_of_copies = num_of_copies;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getYear_of_publication() {
		return year_of_publication;
	}

	public void setYear_of_publication(int year_of_publication) {
		this.year_of_publication = year_of_publication;
	}

	/**
	 * @return the waitlist
	 */
	public List<User> getWaitlist() {
		return waitlist;
	}

	/**
	 * @param waitlist 
	 * the waitlist to set
	 */
	public void setWaitlist(List<User> waitlist) {
		this.waitlist = waitlist;
	}
	



	/**
	 * @return the currentUsers
	 */
	public List<UserBook> getCurrentUsers() {
		return currentUsers;
	}

	/**
	 * @param currentUsers the currentUsers to set
	 */
	public void setCurrentUsers(List<UserBook> currentUsers) {
		this.currentUsers = currentUsers;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


}
