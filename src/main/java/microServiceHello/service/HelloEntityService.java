package microServiceHello.service;

import microServiceHello.model.HelloEntity;
import microServiceHello.repository.HelloEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloEntityService {
    private HelloEntityRepository helloEntityRepository;

    @Autowired
    public void setCountForHelloRepository(HelloEntityRepository helloEntityRepository){
        this.helloEntityRepository = helloEntityRepository;
    }

    @Transactional
    public void saveHello(HelloEntity helloEntity){
        helloEntityRepository.save(helloEntity);
    }

    @Transactional
    public HelloEntity getByIdName(String id) {
        return helloEntityRepository.getByIdName(id);
    }

}
