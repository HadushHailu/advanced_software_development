package customer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "my-config.app")
public class MyConfigProperties {
    private String name;
    private String version;
    private String serverUrl;
    private String serverName;
    private User user;
    private List<String> countries;

    @Override
    public String toString() {
        return "MyConfigProperties{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", serverUrl='" + serverUrl + '\'' +
                ", serverName='" + serverName + '\'' +
                ", user=" + user +
                ", countries=" + countries +
                '}';
    }

    public MyConfigProperties(String name, String version, String serverUrl, String serverName, User user, List<String> countries) {
        this.name = name;
        this.version = version;
        this.serverUrl = serverUrl;
        this.serverName = serverName;
        this.user = user;
        this.countries = countries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public static class User{
        private String first_Name;
        private String last_Name;
        private String user_Name;
        private String password;

        public User() {
        }

        @Override
        public String toString() {
            return "User{" +
                    "first_Name='" + first_Name + '\'' +
                    ", last_Name='" + last_Name + '\'' +
                    ", user_Name='" + user_Name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public User(String first_Name, String last_Name, String user_Name, String password) {
            this.first_Name = first_Name;
            this.last_Name = last_Name;
            this.user_Name = user_Name;
            this.password = password;
        }

        public String getFirst_Name() {
            return first_Name;
        }

        public void setFirst_Name(String first_Name) {
            this.first_Name = first_Name;
        }

        public String getLast_Name() {
            return last_Name;
        }

        public void setLast_Name(String last_Name) {
            this.last_Name = last_Name;
        }

        public String getUser_Name() {
            return user_Name;
        }

        public void setUser_Name(String user_Name) {
            this.user_Name = user_Name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
