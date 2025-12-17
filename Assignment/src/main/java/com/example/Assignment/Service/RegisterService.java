package com.example.Assignment.Service;

import com.example.Assignment.DTO.RegisterDTO;
import com.example.Assignment.DTO.RegisterDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    private List<RegisterDTO> registers = new ArrayList<>();
    private Long idCounter = 1L; //auto increment

    public void register(RegisterDTO dto) {// register controller
        dto.setId(idCounter++);
        registers.add(dto);
    }

    public RegisterDTO getById(Long id) {
        for (RegisterDTO dto : registers) {
            if (dto.getId().equals(id)) {
                return dto;
            }
        }
        return null;
    }

    public List<RegisterDTO> getAll() {
        return registers;
    }

}
