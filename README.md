# 🌾 Farmon on Metaverse

Metaverse dünyasında e-ticaret ve sipariş yönetimi için geliştirilmiş bir **Spring Boot REST API** uygulamasıdır. JWT tabanlı kimlik doğrulama, rol bazlı yetkilendirme ve sipariş yönetimi gibi temel özellikleri sunar.

## 📋 İçerik

- [Amaç](#-amaç)
- [Tech Stack](#-tech-stack)
- [Proje Yapısı](#-proje-yapısı)
- [API Endpoints](#-api-endpoints)
- [Kurulum](#-kurulum)
- [Veritabanı Şeması](#-veritabanı-şeması)

## 🎯 Amaç

Bu proje, metaverse platformlarına entegre edilebilecek bir backend servisi sağlamayı amaçlamaktadır. Temel hedefler:

- **Kullanıcı Yönetimi** – Kayıt, giriş ve profil işlemleri
- **Kimlik Doğrulama** – JWT token ile güvenli oturum yönetimi
- **Sipariş Yönetimi** – Sipariş oluşturma, listeleme ve silme
- **Rol Bazlı Erişim** – Admin ve kullanıcı rollerine göre yetkilendirme

## 🛠 Tech Stack

| Kategori | Teknoloji |
|---|---|
| **Dil** | Java 17 |
| **Framework** | Spring Boot 3.0.4 |
| **Güvenlik** | Spring Security, JWT (JJWT 0.11.5) |
| **Veritabanı** | MySQL 8.0.28 |
| **ORM** | Spring Data JPA / Hibernate |
| **API Dokümantasyonu** | Springdoc OpenAPI 2.0.2 (Swagger UI) |
| **Build Aracı** | Maven |
| **Diğer** | Lombok, BCrypt |

## 📁 Proje Yapısı

```
src/main/java/com/metaverse/farmon/
├── config/          # Uygulama konfigürasyon sınıfları
├── controller/      # REST API endpoint'leri
├── model/           # JPA Entity sınıfları (User, Order)
├── repository/      # Veritabanı erişim katmanı
├── service/         # İş mantığı katmanı
├── security/        # JWT, Spring Security, CORS ayarları
├── mapper/          # DTO dönüşüm sınıfları
├── exception/       # Özel hata sınıfları
└── runner/          # Uygulama başlatma işlemleri
```

## 🔗 API Endpoints

### Kimlik Doğrulama (`/auth`)

| Metot | Endpoint | Açıklama |
|---|---|---|
| POST | `/auth/authenticate` | Kullanıcı girişi (JWT token döner) |
| POST | `/auth/signup` | Yeni kullanıcı kaydı |

### Kullanıcılar (`/api/users`)

| Metot | Endpoint | Yetki | Açıklama |
|---|---|---|---|
| GET | `/api/users/me` | USER | Mevcut kullanıcı bilgileri |
| GET | `/api/users` | ADMIN | Tüm kullanıcıları listele |
| GET | `/api/users/{username}` | ADMIN | Belirli kullanıcıyı getir |
| DELETE | `/api/users/{username}` | ADMIN | Kullanıcıyı sil |

### Siparişler (`/api/orders`)

| Metot | Endpoint | Yetki | Açıklama |
|---|---|---|---|
| GET | `/api/orders` | ADMIN | Siparişleri listele (metin filtresi destekler) |
| POST | `/api/orders` | USER | Yeni sipariş oluştur |
| DELETE | `/api/orders/{id}` | ADMIN | Siparişi sil |

> 📖 Swagger UI üzerinden tüm endpoint'leri inceleyebilirsiniz: `/swagger-ui.html`

## 🚀 Kurulum

### Gereksinimler

- Java 17+
- Maven
- MySQL 8.0+

### Adımlar

1. **Repoyu klonlayın:**
   ```bash
   git clone https://github.com/melihaycicek/farmonOnMetaverse.git
   cd farmonOnMetaverse
   ```

2. **MySQL veritabanını oluşturun:**
   ```sql
   CREATE DATABASE farmon_db;
   ```

3. **`application.properties` dosyasını düzenleyin** (`src/main/resources/application.properties`):
   ```properties
   spring.datasource.username=KULLANICI_ADINIZ
   spring.datasource.password=SIFRENIZ
   ```

4. **Uygulamayı başlatın:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **API'ye erişin:**
   - Uygulama: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

## 🗄 Veritabanı Şeması

```
┌──────────────┐       ┌──────────────┐
│    users     │       │    orders    │
├──────────────┤       ├──────────────┤
│ id (PK)      │──┐    │ id (PK/UUID) │
│ username     │  │    │ description  │
│ password     │  └───>│ user_id (FK) │
│ name         │       │ created_at   │
│ email        │       └──────────────┘
│ role         │
└──────────────┘
```

**İlişki:** Bir kullanıcının birden fazla siparişi olabilir (1:N).
