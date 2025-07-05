#### Pemuda Programmer Java

---

#### Aplication

- brand

---

#### Requirement

- java >= 17
- mvn  >= 3.9.10

---

#### Setup Installation

1. Clone repository :
   ```bash
   $ git clone -b development https://github.com/ravel28/pemuda-programmer-java
   ```

#### File Location

2. Go to project folder :
   ```bash
   $ cd pemuda-programmer-java
   ```

#### Setting aplication.propeties

5. Setting aplication.propeties
   ```bash
   $ change .env.example to .env and setting your port and database to get data
   ```

#### Running Database

6. Create prisma typeScript ORM :
   ```bash
   $ yarn prisma:generate:schema
   $ yarn prisma db push
   ```

#### Running Application

7. Run the web server :
   ```bash
   $ yarn run start:dev
   ```

#### Contributors

- Muhammad Reza Ravelinno

### Contact Me

- ravelinno9@gmail.com
