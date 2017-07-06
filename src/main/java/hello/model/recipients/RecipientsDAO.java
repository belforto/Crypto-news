/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.model.recipients;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Markoo
 */

@Transactional
public interface RecipientsDAO extends CrudRepository< Recipients, Long> {
    
    
    
    public  Recipients findByIdrecipient(Long id);
    
    
    /**
     *
     * @return
     */
    @Override
    public List< Recipients> findAll();
}