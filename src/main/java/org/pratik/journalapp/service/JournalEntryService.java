package org.pratik.journalapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.pratik.journalapp.entity.JournalEntry;
import org.pratik.journalapp.entity.User;
import org.pratik.journalapp.repository.JournalRepository;
import org.pratik.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JournalEntryService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalRepository journalRepository;

    public List<JournalEntry> getAll(String username) {
        try {
            User user = userRepository.findByUsername(username);
            return user.getJournalEntries();
        } catch (Exception e) {
            return null;
        }
    }

    public JournalEntry getById(String username, ObjectId id) {
        try {
            User user = userRepository.findByUsername(username);
            return user.getJournalEntries()
                    .stream().filter(x -> id.equals(x.getId()))
                    .findAny().orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public JournalEntry saveNewEntry(String username, JournalEntry entry) {
        try {
            User user = userRepository.findByUsername(username);
            entry.setDate(LocalDateTime.now());
            JournalEntry savedEntry = journalRepository.save(entry);

            user.getJournalEntries().add(savedEntry);
            userRepository.save(user);
            return savedEntry;
        } catch (Exception e) {
            return null;
        }
    }

    public JournalEntry updateEntry(String username, ObjectId id, JournalEntry newEntry) {
        try {
            User user = userRepository.findByUsername(username);
            JournalEntry entry = user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).findAny()
                    .orElse(null);
            if (entry == null) {
                return null;
            }
            entry.setTitle(
                    (newEntry.getTitle() != null || !newEntry.getTitle().equals("")) ? newEntry.getTitle()
                            : entry.getTitle());
            entry.setContent(
                    (newEntry.getContent() != null || !newEntry.getContent().equals("")) ? newEntry.getContent()
                            : entry.getContent());
            JournalEntry saved = journalRepository.save(entry);
            userRepository.save(user);

            return saved;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public boolean deleteEntry(String username, ObjectId id) {
        try {
            User user = userRepository.findByUsername(username);
            boolean deleted = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (deleted == true) {
                journalRepository.deleteById(id);
                userRepository.save(user);
            }
            return deleted;
        } catch (Exception e) {
            return false;
        }
    }

}
