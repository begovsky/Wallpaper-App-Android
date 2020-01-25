package com.begovsky.pozadineaplikacija.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageJsonObject {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    private class Ancestry {

        @SerializedName("type")
        @Expose
        private Type type;
        @SerializedName("category")
        @Expose
        private Category category;
        @SerializedName("subcategory")
        @Expose
        private Subcategory subcategory;

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Subcategory getSubcategory() {
            return subcategory;
        }

        public void setSubcategory(Subcategory subcategory) {
            this.subcategory = subcategory;
        }

    }

    private class Category {

        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("pretty_slug")
        @Expose
        private String prettySlug;

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getPrettySlug() {
            return prettySlug;
        }

        public void setPrettySlug(String prettySlug) {
            this.prettySlug = prettySlug;
        }

    }

    private class CoverPhoto {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("promoted_at")
        @Expose
        private String promotedAt;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("alt_description")
        @Expose
        private String altDescription;
        @SerializedName("urls")
        @Expose
        private Urls_ urls;
        @SerializedName("links")
        @Expose
        private Links__ links;
        @SerializedName("categories")
        @Expose
        private List<Object> categories = null;
        @SerializedName("likes")
        @Expose
        private Integer likes;
        @SerializedName("liked_by_user")
        @Expose
        private Boolean likedByUser;
        @SerializedName("current_user_collections")
        @Expose
        private List<Object> currentUserCollections = null;
        @SerializedName("user")
        @Expose
        private User_ user;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getPromotedAt() {
            return promotedAt;
        }

        public void setPromotedAt(String promotedAt) {
            this.promotedAt = promotedAt;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAltDescription() {
            return altDescription;
        }

        public void setAltDescription(String altDescription) {
            this.altDescription = altDescription;
        }

        public Urls_ getUrls() {
            return urls;
        }

        public void setUrls(Urls_ urls) {
            this.urls = urls;
        }

        public Links__ getLinks() {
            return links;
        }

        public void setLinks(Links__ links) {
            this.links = links;
        }

        public List<Object> getCategories() {
            return categories;
        }

        public void setCategories(List<Object> categories) {
            this.categories = categories;
        }

        public Integer getLikes() {
            return likes;
        }

        public void setLikes(Integer likes) {
            this.likes = likes;
        }

        public Boolean getLikedByUser() {
            return likedByUser;
        }

        public void setLikedByUser(Boolean likedByUser) {
            this.likedByUser = likedByUser;
        }

        public List<Object> getCurrentUserCollections() {
            return currentUserCollections;
        }

        public void setCurrentUserCollections(List<Object> currentUserCollections) {
            this.currentUserCollections = currentUserCollections;
        }

        public User_ getUser() {
            return user;
        }

        public void setUser(User_ user) {
            this.user = user;
        }

    }

    private class Links {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("download")
        @Expose
        private String download;
        @SerializedName("download_location")
        @Expose
        private String downloadLocation;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownloadLocation() {
            return downloadLocation;
        }

        public void setDownloadLocation(String downloadLocation) {
            this.downloadLocation = downloadLocation;
        }

    }

    private class Links_ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("photos")
        @Expose
        private String photos;
        @SerializedName("likes")
        @Expose
        private String likes;
        @SerializedName("portfolio")
        @Expose
        private String portfolio;
        @SerializedName("following")
        @Expose
        private String following;
        @SerializedName("followers")
        @Expose
        private String followers;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public String getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(String portfolio) {
            this.portfolio = portfolio;
        }

        public String getFollowing() {
            return following;
        }

        public void setFollowing(String following) {
            this.following = following;
        }

        public String getFollowers() {
            return followers;
        }

        public void setFollowers(String followers) {
            this.followers = followers;
        }

    }

    private class Links__ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("download")
        @Expose
        private String download;
        @SerializedName("download_location")
        @Expose
        private String downloadLocation;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownloadLocation() {
            return downloadLocation;
        }

        public void setDownloadLocation(String downloadLocation) {
            this.downloadLocation = downloadLocation;
        }

    }

    private class Links___ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("photos")
        @Expose
        private String photos;
        @SerializedName("likes")
        @Expose
        private String likes;
        @SerializedName("portfolio")
        @Expose
        private String portfolio;
        @SerializedName("following")
        @Expose
        private String following;
        @SerializedName("followers")
        @Expose
        private String followers;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public String getPortfolio() {
            return portfolio;
        }

        public void setPortfolio(String portfolio) {
            this.portfolio = portfolio;
        }

        public String getFollowing() {
            return following;
        }

        public void setFollowing(String following) {
            this.following = following;
        }

        public String getFollowers() {
            return followers;
        }

        public void setFollowers(String followers) {
            this.followers = followers;
        }

    }

    private class ProfileImage {

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

    }

    private class ProfileImage_ {

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

    }

    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("promoted_at")
        @Expose
        private String promotedAt;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("color")
        @Expose
        private String color;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("alt_description")
        @Expose
        private String altDescription;
        @SerializedName("urls")
        @Expose
        private Urls urls;
        @SerializedName("links")
        @Expose
        private Links links;
        @SerializedName("categories")
        @Expose
        private List<Object> categories = null;
        @SerializedName("likes")
        @Expose
        private Integer likes;
        @SerializedName("liked_by_user")
        @Expose
        private Boolean likedByUser;
        @SerializedName("current_user_collections")
        @Expose
        private List<Object> currentUserCollections = null;
        @SerializedName("user")
        @Expose
        private User user;
        @SerializedName("tags")
        @Expose
        private List<Tag> tags = null;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getPromotedAt() {
            return promotedAt;
        }

        public void setPromotedAt(String promotedAt) {
            this.promotedAt = promotedAt;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAltDescription() {
            return altDescription;
        }

        public void setAltDescription(String altDescription) {
            this.altDescription = altDescription;
        }

        public Urls getUrls() {
            return urls;
        }

        public void setUrls(Urls urls) {
            this.urls = urls;
        }

        public Links getLinks() {
            return links;
        }

        public void setLinks(Links links) {
            this.links = links;
        }

        public List<Object> getCategories() {
            return categories;
        }

        public void setCategories(List<Object> categories) {
            this.categories = categories;
        }

        public Integer getLikes() {
            return likes;
        }

        public void setLikes(Integer likes) {
            this.likes = likes;
        }

        public Boolean getLikedByUser() {
            return likedByUser;
        }

        public void setLikedByUser(Boolean likedByUser) {
            this.likedByUser = likedByUser;
        }

        public List<Object> getCurrentUserCollections() {
            return currentUserCollections;
        }

        public void setCurrentUserCollections(List<Object> currentUserCollections) {
            this.currentUserCollections = currentUserCollections;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public List<Tag> getTags() {
            return tags;
        }

        public void setTags(List<Tag> tags) {
            this.tags = tags;
        }

    }

    private class Source {

        @SerializedName("ancestry")
        @Expose
        private Ancestry ancestry;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("subtitle")
        @Expose
        private String subtitle;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("meta_title")
        @Expose
        private String metaTitle;
        @SerializedName("meta_description")
        @Expose
        private String metaDescription;
        @SerializedName("cover_photo")
        @Expose
        private CoverPhoto coverPhoto;

        public Ancestry getAncestry() {
            return ancestry;
        }

        public void setAncestry(Ancestry ancestry) {
            this.ancestry = ancestry;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMetaTitle() {
            return metaTitle;
        }

        public void setMetaTitle(String metaTitle) {
            this.metaTitle = metaTitle;
        }

        public String getMetaDescription() {
            return metaDescription;
        }

        public void setMetaDescription(String metaDescription) {
            this.metaDescription = metaDescription;
        }

        public CoverPhoto getCoverPhoto() {
            return coverPhoto;
        }

        public void setCoverPhoto(CoverPhoto coverPhoto) {
            this.coverPhoto = coverPhoto;
        }

    }

    private class Subcategory {

        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("pretty_slug")
        @Expose
        private String prettySlug;

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getPrettySlug() {
            return prettySlug;
        }

        public void setPrettySlug(String prettySlug) {
            this.prettySlug = prettySlug;
        }

    }

    private class Tag {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("source")
        @Expose
        private Source source;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Source getSource() {
            return source;
        }

        public void setSource(Source source) {
            this.source = source;
        }

    }

    private class Type {

        @SerializedName("slug")
        @Expose
        private String slug;
        @SerializedName("pretty_slug")
        @Expose
        private String prettySlug;

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getPrettySlug() {
            return prettySlug;
        }

        public void setPrettySlug(String prettySlug) {
            this.prettySlug = prettySlug;
        }

    }

    public class Urls {

        @SerializedName("raw")
        @Expose
        private String raw;
        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("regular")
        @Expose
        private String regular;
        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

    }

    private class Urls_ {

        @SerializedName("raw")
        @Expose
        private String raw;
        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("regular")
        @Expose
        private String regular;
        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

    }

    private class User {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("twitter_username")
        @Expose
        private String twitterUsername;
        @SerializedName("portfolio_url")
        @Expose
        private Object portfolioUrl;
        @SerializedName("bio")
        @Expose
        private String bio;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("links")
        @Expose
        private Links_ links;
        @SerializedName("profile_image")
        @Expose
        private ProfileImage profileImage;
        @SerializedName("instagram_username")
        @Expose
        private String instagramUsername;
        @SerializedName("total_collections")
        @Expose
        private Integer totalCollections;
        @SerializedName("total_likes")
        @Expose
        private Integer totalLikes;
        @SerializedName("total_photos")
        @Expose
        private Integer totalPhotos;
        @SerializedName("accepted_tos")
        @Expose
        private Boolean acceptedTos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getTwitterUsername() {
            return twitterUsername;
        }

        public void setTwitterUsername(String twitterUsername) {
            this.twitterUsername = twitterUsername;
        }

        public Object getPortfolioUrl() {
            return portfolioUrl;
        }

        public void setPortfolioUrl(Object portfolioUrl) {
            this.portfolioUrl = portfolioUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Links_ getLinks() {
            return links;
        }

        public void setLinks(Links_ links) {
            this.links = links;
        }

        public ProfileImage getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(ProfileImage profileImage) {
            this.profileImage = profileImage;
        }

        public String getInstagramUsername() {
            return instagramUsername;
        }

        public void setInstagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
        }

        public Integer getTotalCollections() {
            return totalCollections;
        }

        public void setTotalCollections(Integer totalCollections) {
            this.totalCollections = totalCollections;
        }

        public Integer getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(Integer totalLikes) {
            this.totalLikes = totalLikes;
        }

        public Integer getTotalPhotos() {
            return totalPhotos;
        }

        public void setTotalPhotos(Integer totalPhotos) {
            this.totalPhotos = totalPhotos;
        }

        public Boolean getAcceptedTos() {
            return acceptedTos;
        }

        public void setAcceptedTos(Boolean acceptedTos) {
            this.acceptedTos = acceptedTos;
        }

    }

    private class User_ {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("twitter_username")
        @Expose
        private String twitterUsername;
        @SerializedName("portfolio_url")
        @Expose
        private Object portfolioUrl;
        @SerializedName("bio")
        @Expose
        private String bio;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("links")
        @Expose
        private Links___ links;
        @SerializedName("profile_image")
        @Expose
        private ProfileImage_ profileImage;
        @SerializedName("instagram_username")
        @Expose
        private String instagramUsername;
        @SerializedName("total_collections")
        @Expose
        private Integer totalCollections;
        @SerializedName("total_likes")
        @Expose
        private Integer totalLikes;
        @SerializedName("total_photos")
        @Expose
        private Integer totalPhotos;
        @SerializedName("accepted_tos")
        @Expose
        private Boolean acceptedTos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getTwitterUsername() {
            return twitterUsername;
        }

        public void setTwitterUsername(String twitterUsername) {
            this.twitterUsername = twitterUsername;
        }

        public Object getPortfolioUrl() {
            return portfolioUrl;
        }

        public void setPortfolioUrl(Object portfolioUrl) {
            this.portfolioUrl = portfolioUrl;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Links___ getLinks() {
            return links;
        }

        public void setLinks(Links___ links) {
            this.links = links;
        }

        public ProfileImage_ getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(ProfileImage_ profileImage) {
            this.profileImage = profileImage;
        }

        public String getInstagramUsername() {
            return instagramUsername;
        }

        public void setInstagramUsername(String instagramUsername) {
            this.instagramUsername = instagramUsername;
        }

        public Integer getTotalCollections() {
            return totalCollections;
        }

        public void setTotalCollections(Integer totalCollections) {
            this.totalCollections = totalCollections;
        }

        public Integer getTotalLikes() {
            return totalLikes;
        }

        public void setTotalLikes(Integer totalLikes) {
            this.totalLikes = totalLikes;
        }

        public Integer getTotalPhotos() {
            return totalPhotos;
        }

        public void setTotalPhotos(Integer totalPhotos) {
            this.totalPhotos = totalPhotos;
        }

        public Boolean getAcceptedTos() {
            return acceptedTos;
        }

        public void setAcceptedTos(Boolean acceptedTos) {
            this.acceptedTos = acceptedTos;
        }

    }

}

