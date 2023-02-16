package powertool.demo.Entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "powerapp", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String nickName;
    private String passWord;
    private String realName;
    private String sex;
    private String phone;
    private String province;
    private String city;
    private String school;
    private String identityId;
    private String exp;
    private byte[] headUrl;
    private String introduceMe;
    private Integer totalExp;

    @Id
    @Column(name = "userId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "nickName")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "passWord")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "realName")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "identityId")
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Basic
    @Column(name = "exp")
    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    @Basic
    @Column(name = "headUrl")
    public byte[] getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(byte[] headUrl) {
        this.headUrl = headUrl;
    }

    @Basic
    @Column(name = "introduceMe")
    public String getIntroduceMe() {
        return introduceMe;
    }

    public void setIntroduceMe(String introduceMe) {
        this.introduceMe = introduceMe;
    }

    @Basic
    @Column(name = "total_exp")
    public Integer getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(Integer totalExp) {
        this.totalExp = totalExp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(nickName, that.nickName) &&
                Objects.equals(passWord, that.passWord) &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(school, that.school) &&
                Objects.equals(identityId, that.identityId) &&
                Objects.equals(exp, that.exp) &&
                Arrays.equals(headUrl, that.headUrl) &&
                Objects.equals(introduceMe, that.introduceMe) &&
                Objects.equals(totalExp, that.totalExp);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userName, nickName, passWord, realName, sex, phone, province, city, school, identityId, exp, introduceMe, totalExp);
        result = 31 * result + Arrays.hashCode(headUrl);
        return result;
    }

    public UserEntity() {
    }

    public UserEntity(int userId, String userName, String nickName, String passWord, String realName, String sex, String phone, String province, String city, String school, String identityId, String exp, byte[] headUrl, String introduceMe, Integer totalExp) {
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.passWord = passWord;
        this.realName = realName;
        this.sex = sex;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.school = school;
        this.identityId = identityId;
        this.exp = exp;
        this.headUrl = headUrl;
        this.introduceMe = introduceMe;
        this.totalExp = totalExp;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", school='" + school + '\'' +
                ", identityId='" + identityId + '\'' +
                ", exp='" + exp + '\'' +
                ", headUrl=" + Arrays.toString(headUrl) +
                ", introduceMe='" + introduceMe + '\'' +
                ", totalExp=" + totalExp +
                '}';
    }
}
