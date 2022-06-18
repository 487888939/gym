package com.gymSQL.pojo;

public class manager {
    private Integer id;
    private String m_name ;
	private String password;
    private String state;
    public manager() {
    }
    public manager(Integer id, String m_name, String password, String state) {
        this.id = id;
        this.m_name = m_name;
        this.password = password;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "manager{" +
                "id=" + id +
                ", m_name='" + m_name + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
