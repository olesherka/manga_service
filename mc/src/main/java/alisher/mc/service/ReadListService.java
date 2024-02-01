package alisher.mc.service;

import alisher.mc.model.Genre;
import alisher.mc.model.Read_list;
import alisher.mc.repository.GenreRepository;
import alisher.mc.repository.ReadListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j

public class ReadListService {
    private ReadListRepository readListRepository;

    @Autowired
    public ReadListService(ReadListRepository readListRepository) {
        this.readListRepository = readListRepository;
    }

    public List<Read_list> getAllReadLists(){
        return readListRepository.getAllReadLists();
    }

    public Read_list addReadList(Read_list readList){
        if(readListRepository.findById(readList.getRead_list_id()) == null){
            return readListRepository.save(readList);
        }
        else{
            throw new IllegalStateException("Read list with id(" + readList.getRead_list_id() + ") already exist");
        }
    }

    public Read_list findReadListById(int id){
        return readListRepository.findById(id);
    }

    public void deleteReadListById(int id){
        readListRepository.deleteById(id);
    }


    public Read_list updateReadList(int read_list_id, Read_list readList){
        if(readListRepository.findById(read_list_id) != null){
            readList.setRead_list_id(read_list_id);
            return readListRepository.save(readList);
        }
        else{
            throw new NoSuchElementException("Read List with id(" + read_list_id + ") not found");
        }
    }
}