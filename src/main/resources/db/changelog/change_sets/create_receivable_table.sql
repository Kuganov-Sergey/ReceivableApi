create table accounts_receivable (
    id serial primary key not null,
    name varchar(50) not null,
    account_number integer not null,
    shipment_date date not null,
    payment_date date not null,
    amount decimal(9,2) not null,
    days_left integer not null
);