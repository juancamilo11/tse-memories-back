package co.edu.practice.tse.services;

import co.edu.practice.tse.collections.ProtectedMemory;
import co.edu.practice.tse.repositories.ProtectedMemoryRepository;
import co.edu.practice.tse.services.interfaces.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final ProtectedMemoryRepository protectedMemoryRepository;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String FROM;

    @Override
    public String sendMessageForMemorySharing(String memoryId, String senderName, String email) {
        Optional<ProtectedMemory> protectedMemoryOptional = protectedMemoryRepository.findById(memoryId);
        protectedMemoryOptional.ifPresent(protectedMemory -> {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(FROM);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("¡Saludos, " + senderName + " te ha compartido una gran historia!");
            simpleMailMessage.setText("Se ha compartido contigo la historia " + protectedMemory.getName() + " ocurrida en " +
                    protectedMemory.getLocation().getCity() + ", " + protectedMemory.getLocation().getCountry() + " el " +
                    protectedMemory.getMemoryDate().toString() + "." + "\n" + "¡Visita https://tse-memories.firebaseapp.com para verlo!");
            javaMailSender.send(simpleMailMessage);
        });
        return protectedMemoryOptional.map(protectedMemory -> "Mensaje Enviado").orElse("");
    }
}
