package com.ustc.overwatch;

public class Client extends Data {
    private boolean isOnline;
    private String  ip;
    private String  name;

    /**
     * Getter for property 'online'.
     *
     * @return Value for property 'online'.
     */
    public boolean isOnline() {
        return isOnline;
    }

    /**
     * Setter for property 'online'.
     *
     * @param online Value to set for property 'online'.
     */
    public void setOnline(boolean online) {
        isOnline = online;
    }

    /**
     * Getter for property 'ip'.
     *
     * @return Value for property 'ip'.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Setter for property 'ip'.
     *
     * @param ip Value to set for property 'ip'.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (isOnline != client.isOnline) return false;
        if (ip != null ? !ip.equals(client.ip) : client.ip != null) return false;
        return name != null ? name.equals(client.name) : client.name == null;
    }

    @Override
    public int hashCode() {
        int result = (isOnline ? 1 : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
