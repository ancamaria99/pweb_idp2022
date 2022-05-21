package license.refugeesShelter.translator;

import license.refugeesShelter.domain.Booking;
import license.refugeesShelter.domain.dto.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BookingTranslator {

    private final ShelterTranslator shelterTranslator;

    public BookingDto generateBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();

        bookingDto.setBookingId(booking.getBookingId());
        bookingDto.setName(booking.getName());
        bookingDto.setAveragePricePerNightPerPerson(booking.getAveragePricePerNightPerPerson());
        bookingDto.setLink(booking.getLink());

        return bookingDto;
    }

    public List<BookingDto> generateBookingDtoList(List<Booking> bookings) {
        return bookings.stream().map(this::generateBookingDto).collect(Collectors.toList());
    }
}
