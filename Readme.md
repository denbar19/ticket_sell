### Setup

    docker-compose.yml up -d

Create database, schema, tables from schema.sql.
Insert data into tables, you can use from the example.


Run application with VM options:

    -Dspring.profiles.active=dev

If found this error when using java modules. Caused by: java.lang.IllegalAccessError: class com.denysenko.payment.PaymentApplication$$SpringCGLIB$$0 
(in module com.denysenko.payment) cannot access class org.springframework.cglib.core.ReflectUtils (in unnamed module @0xc8c12ac)
because module com.denysenko.payment does not read unnamed module @0xc8c12ac

    --add-reads com.denysenko.ticketcontrol=ALL-UNNAMED
    --add-reads com.denysenko.payment=ALL-UNNAMED




