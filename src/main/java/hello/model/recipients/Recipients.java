/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model.recipients;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Markoo
 */
@Entity
@Table(name = "recipients")
public class Recipients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRecipient")
    private Long idrecipient;
    
    @Lob
    @Size(max = 16777215)
    @Column(name = "emailLongString")
    private String emailLongString;
    

    public Recipients() {
    }

    public Recipients(Long idfplayer) {
        this.idrecipient = idfplayer;
    }

    public Long getIdrecipient() {
        return idrecipient;
    }

    public void setIdrecipient(Long idrecipient) {
        this.idrecipient = idrecipient;
    }

    

    @Override
    public String toString() {
        return "Recipients are [ Id =" + getIdrecipient() + " ]";
    }

    /**
     * @return the emailLongString
     */
    public String getEmailLongString() {
        return emailLongString;
    }

    /**
     * @param emailLongString the emailLongString to set
     */
    public void setEmailLongString(String emailLongString) {
        this.emailLongString = emailLongString;
    }
    
}
