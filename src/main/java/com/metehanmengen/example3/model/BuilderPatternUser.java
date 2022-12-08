package src.main.java.com.metehanmengen.example3.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Çok argümanlı User sınıfı Builder - fluent pattern'i ile yapımı.
public class BuilderPatternUser {

	private String name;
	private String mail;
	private String password;
	private UserType type;
	private List<Realty> realtyList;
	private List<Realty>  favoriteRealtyList;
	private List<Message> messages;
	private LocalDateTime createDate;

	private BuilderPatternUser(String name, String mail, String password, UserType type,
							  List<Realty> realtyList, List<Realty> favoriteRealtyList,
							  List<Message> messages, LocalDateTime createDate)
	{
		this.name = name;
		this.mail = mail;
		this.password = password;
		this.type = type;
		this.realtyList = realtyList;
		this.favoriteRealtyList = favoriteRealtyList;
		this.messages = messages;
		this.createDate = createDate;
	}

	public static class Builder {
		private final BuilderPatternUser user = new BuilderPatternUser("Default", "@gmail.com",
				"123345", UserType.INDIVIDUAL, new ArrayList<>(), new ArrayList<>(),
				new ArrayList<>(), LocalDateTime.now());

		public String getName() {
			return user.name;
		}

		public Builder setName(String name) {
			user.name = name;
			return this;
		}

		public String getMail() {
			return user.mail;
		}

		public Builder setMail(String mail) {
			user.mail = mail;
			return this;
		}

		public String getPassword() {
			return user.password;
		}

		public Builder setPassword(String password) {
			user.password = password;
			return this;
		}

		public UserType getType() {
			return user.type;
		}

		public Builder setType(UserType type) {
			user.type = type;
			return this;
		}

		public List<Realty> getRealtyList() {
			return user.realtyList;
		}

		public Builder setRealtyList(List<Realty> realtyList) {
			user.realtyList = realtyList;
			return this;
		}

		public List<Realty> getFavoriteRealtyList() {
			return user.favoriteRealtyList;
		}

		public Builder setFavoriteRealtyList(List<Realty> favoriteRealtyList) {
			user.favoriteRealtyList = favoriteRealtyList;
			return this;
		}

		public List<Message> getMessages() {
			return user.messages;
		}

		public Builder setMessages(List<Message> messages) {
			user.messages = messages;
			return this;
		}

		public LocalDateTime getCreateDate() {
			return user.createDate;
		}

		public Builder setCreateDate(LocalDateTime createDate) {
			user.createDate = createDate;
			return this;
		}

		public BuilderPatternUser build()
		{
			return user;
		}

	}

	public void show()
	{
		if (!name.isEmpty())
			System.out.println(name + " ");
		if (!mail.isEmpty())
			System.out.println(mail + " ");
		if (!password.isEmpty())
			System.out.println(password + " ");
		if (type != null)
			System.out.println(type + " ");
		if (!realtyList.isEmpty())
			System.out.println(realtyList + " ");
		if (!favoriteRealtyList.isEmpty())
			System.out.println(favoriteRealtyList + " ");
		if (!messages.isEmpty())
			System.out.println(messages + " ");
		if (createDate != null)
			System.out.println(createDate + " ");

	}




}
