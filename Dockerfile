FROM eclipse-temurin:17-jdk-alpine

# Thiết lập thư mục làm việc mặc định
WORKDIR /airline-booking

# Sao chép file JAR từ máy tính host vào container
COPY target/airline-booking-0.0.1-SNAPSHOT.jar airline-booking.jar

# Chạy ứng dụng khi container khởi động
CMD ["java", "-jar", "-Dspring.profiles.active=dev-public", "airline-booking.jar"]

EXPOSE 8008