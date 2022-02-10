package at.htl.control;

import at.htl.entity.Workstation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class WorkstationRepository implements PanacheRepository<Workstation> {

    public List<Workstation> getByName(String name){
        return this.find("select w from Workstation w where w.nameOfStation =: name",name).list();
    }
}
