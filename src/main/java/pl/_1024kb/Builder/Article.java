package pl._1024kb.Builder;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Article
{
    private long id;
    private String title;
    private String content;
    private LocalDate publishDate;
    private List<Tag> tags;
    private Category category;
    private Author author;

    public static NeedId builder()
    {
        return new Builder();
    }

    public static class Builder implements NeedId, NeedTitle, NeedContent, NeedPublishDate, AndNext, CanBeBuild
    {
        private long id;
        private String title;
        private String content;
        private LocalDate publishDate;
        private List<Tag> tags = new LinkedList<>();
        private Category category;
        private Author author;

        @Override
        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        @Override
        public Builder title(String title)
        {
            this.title = title;
            return this;
        }

        @Override
        public Builder content(String content)
        {
            this.content = content;
            return this;
        }

        @Override
        public Builder publishDate(LocalDate publishDate)
        {
            this.publishDate = publishDate;
            return this;
        }

        @Override
        public Builder addTag(Tag tag)
        {
            tags.add(tag);
            return this;
        }

        @Override
        public Builder category(Category category)
        {
            this.category = category;
            return this;
        }

        @Override
        public Builder author(Author author)
        {
            this.author = author;
            return this;
        }

        @Override
        public Builder and()
        {
            return this;
        }

        public Article build()
        {
            Article article = new Article();
            article.id = this.id;
            article.title = this.title;
            article.content = this.content;
            article.publishDate = this.publishDate;
            article.tags = this.tags;
            article.category = this.category;
            article.author = this.author;

            return article;
        }
    }

    public interface NeedId
    {
        public NeedTitle id(long id);
    }

    public interface NeedTitle
    {
        NeedContent title(String title);
    }

    public interface NeedContent
    {
        NeedPublishDate content(String content);
    }

    public interface NeedPublishDate
    {
        AndNext publishDate(LocalDate publishDate);
    }

    public interface AndNext
    {
        CanBeBuild and();
    }

    public interface CanBeBuild
    {
        CanBeBuild addTag(Tag tag);
        CanBeBuild category(Category category);
        CanBeBuild author(Author author);

        Article build();
    }

    @Override
    public String toString()
    {
        return id + "-"
                + title +"-"
                + content + "-"
                + publishDate + "-"
                + tags + "-"
                + category + "-"
                + author;
    }
}

