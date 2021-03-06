package pl._1024kb.Builder;

public class Camel
{
    private long id;
    private String name;
    private int age;
    private Gender gender;
    private float weight;
    private float height;
    private String furColor;

    public static NeedId builder()
    {
        return new Builder();
    }

    public static class Builder implements NeedId, NeedName, NeedAge, NeedGender, AndNext, CanBeBuild
    {
        private long id;
        private String name;
        private int age;
        private Gender gender;
        private float weight;
        private float height;
        private String furColor;

        @Override
        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        @Override
        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        @Override
        public Builder age(int age)
        {
            this.age = age;
            return this;
        }

        @Override
        public Builder gender(Gender gender)
        {
            this.gender = gender;
            return this;
        }

        @Override
        public Builder weight(float weight)
        {
            this.weight = weight;
            return this;
        }

        @Override
        public Builder height(float height)
        {
            this.height = height;
            return this;
        }

        @Override
        public Builder furColor(String furColor)
        {
            this.furColor = furColor;
            return this;
        }

        @Override
        public Builder and()
        {
            return this;
        }

        public Camel build()
        {
            Camel camel = new Camel();
            camel.id = this.id;
            camel.name = this.name;
            camel.age = this.age;
            camel.gender = this.gender;
            camel.weight = this.weight;
            camel.height = this.height;
            camel.furColor = this.furColor;

            return camel;
        }
    }

    public interface NeedId
    {
        public NeedName id(long id);
    }

    public interface NeedName
    {
        NeedAge name(String name);
    }

    public interface NeedAge
    {
        NeedGender age(int age);
    }

    public interface NeedGender
    {
        AndNext gender(Gender gender);
    }

    public interface AndNext
    {
        CanBeBuild and();
    }

    public interface CanBeBuild
    {
        CanBeBuild weight(float weight);
        CanBeBuild height(float height);
        CanBeBuild furColor(String furColor);

        Camel build();
    }

    @Override
    public String toString()
    {
        return id + "-"
                + name +"-"
                + age + "-"
                + gender + "-"
                + weight + "-"
                + height + "-"
                + furColor;
    }
}
