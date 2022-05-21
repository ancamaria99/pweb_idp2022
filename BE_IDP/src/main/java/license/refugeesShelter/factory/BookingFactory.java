package license.refugeesShelter.factory;

import license.refugeesShelter.domain.Booking;
import license.refugeesShelter.domain.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingFactory {

    private final ShelterFactory shelterFactory;

    public Booking toEntity(BookingDto bookingDto) {
        Booking booking = new Booking();

        booking.setBookingId(bookingDto.getBookingId());
        booking.setName(bookingDto.getName());
        booking.setAveragePricePerNightPerPerson(bookingDto.getAveragePricePerNightPerPerson());
        booking.setLink(bookingDto.getLink());

        return booking;
    }
}
