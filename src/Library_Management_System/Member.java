package Library_Management_System;


/**
 * Represents a member of the library.
 */

public class Member {
	
	private int memberId;
	private String name;
	private String email;
	private String phone;
	
	/**
     * Constructs a new Member object.
     *
     * @param memberId the ID of the member
     * @param name     the name of the member
     * @param email    the email of the member
     * @param phone    the phone number of the member
     */
	
	public Member(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
