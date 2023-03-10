package com.webproject.service;

import com.webproject.dao.TagRepo;
import com.webproject.model.Tag;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepo tagRepo;

    public Set<Tag> getByNames(Set<String> names) {
        List<Tag> tags = tagRepo.findAllByTitleIn(names);

        if (tags.isEmpty()) {
            throw new EntityNotFoundException("Tags not found");
        }

        return new HashSet<>(tags);
    }
}
