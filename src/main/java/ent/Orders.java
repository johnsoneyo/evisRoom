/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnson3yo
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByFirstName", query = "SELECT o FROM Orders o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "Orders.findByEmail", query = "SELECT o FROM Orders o WHERE o.email = :email"),
    @NamedQuery(name = "Orders.findByPhone", query = "SELECT o FROM Orders o WHERE o.phone = :phone"),
    @NamedQuery(name = "Orders.findByAddr1", query = "SELECT o FROM Orders o WHERE o.addr1 = :addr1"),
    @NamedQuery(name = "Orders.findByAddr2", query = "SELECT o FROM Orders o WHERE o.addr2 = :addr2"),
    @NamedQuery(name = "Orders.findByModeOfPayment", query = "SELECT o FROM Orders o WHERE o.modeOfPayment = :modeOfPayment"),
    @NamedQuery(name = "Orders.findByTimeEntered", query = "SELECT o FROM Orders o WHERE o.timeEntered = :timeEntered"),
    @NamedQuery(name = "Orders.findByDayOfDelivery", query = "SELECT o FROM Orders o WHERE o.dayOfDelivery = :dayOfDelivery"),
    @NamedQuery(name = "Orders.findByItems", query = "SELECT o FROM Orders o WHERE o.items = :items"),
    @NamedQuery(name = "Orders.findByTitle", query = "SELECT o FROM Orders o WHERE o.title = :title"),
    @NamedQuery(name = "Orders.findByState", query = "SELECT o FROM Orders o WHERE o.state = :state"),
    @NamedQuery(name = "Orders.findByCity", query = "SELECT o FROM Orders o WHERE o.city = :city"),
    @NamedQuery(name = "Orders.findByCountry", query = "SELECT o FROM Orders o WHERE o.country = :country"),
    @NamedQuery(name = "Orders.findByLastName", query = "SELECT o FROM Orders o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "Orders.findByIsDelivered", query = "SELECT o FROM Orders o WHERE o.isDelivered = :isDelivered")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "first_name")
    private String firstName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 32)
    @Column(name = "phone")
    private String phone;
    @Size(max = 256)
    @Column(name = "addr1")
    private String addr1;
    @Size(max = 256)
    @Column(name = "addr2")
    private String addr2;
    @Size(max = 32)
    @Column(name = "mode_of_payment")
    private String modeOfPayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEntered;
    @Basic(optional = false)
    @NotNull
    @Column(name = "day_of_delivery")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayOfDelivery;
    @Column(name = "items")
    private Integer items;
    @Size(max = 8)
    @Column(name = "title")
    private String title;
    @Size(max = 32)
    @Column(name = "state")
    private String state;
    @Size(max = 32)
    @Column(name = "city")
    private String city;
    @Size(max = 32)
    @Column(name = "country")
    private String country;
    @Size(max = 32)
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "is_delivered")
    private Boolean isDelivered;
    @OneToMany(mappedBy = "orderId")
    private List<ProductOrder> productOrderList;
    
    @Transient
    private String fullName;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Orders(Integer id, Date timeEntered, Date dayOfDelivery) {
        this.id = id;
        this.timeEntered = timeEntered;
        this.dayOfDelivery = dayOfDelivery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public Date getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(Date timeEntered) {
        this.timeEntered = timeEntered;
    }

    public Date getDayOfDelivery() {
        return dayOfDelivery;
    }

    public void setDayOfDelivery(Date dayOfDelivery) {
        this.dayOfDelivery = dayOfDelivery;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    @XmlTransient
    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.Orders[ id=" + id + " ]";
    }

    public String getFullName() {
       return title.concat(" ").concat(firstName).concat(" ").concat(lastName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    
    
    
}
