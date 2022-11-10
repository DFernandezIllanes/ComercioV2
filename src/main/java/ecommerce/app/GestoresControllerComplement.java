package ecommerce.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public class GestoresControllerComplement {

    @Autowired
    RepoGestor repoGestor;


}
