DO
$$
BEGIN

CREATE TABLE IF NOT EXISTS outbox_order_message
(
    id           SERIAL,
    type         varchar(100) NOT NULL,
    json_content varchar(512) NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS "order"
(
    id          uuid         NOT NULL,
    "status"    varchar(255) not null,
    client_id    uuid         not null,
    scheduled   timestamptz,
    created_at  timestamptz  not null default now(),
    updated_at  timestamptz  not null default now(),
    constraint pkey__order__id primary key (id)
);

CREATE TABLE IF NOT EXISTS  order_item
(
    id          uuid         not null,
    order_id    uuid         not null,
    "status"    varchar(255) not null,
    product_id  uuid,
    created_at  timestamptz  not null default now(),
    updated_at  timestamptz  not null default now(),

    -- constraints
    constraint pkey__order_item__id primary key (id),
    constraint fkey__order__id__order_item__id foreign key (order_id) references "order" (id)
);

-- initial data


INSERT INTO "order" (id, "status", client_id, scheduled) VALUES ('f7b3b3b1-1b1b-4b1b-8b1b-1b1b1b1b1b1b', 'CREATED', 'f7b3b3b1-1b1b-4b1b-8b1b-1b1b1b1b1b1b', '2021-01-01 00:00:00');
INSERT INTO "order" (id, "status", client_id, scheduled) VALUES ('7afd3d2d-3e46-4197-a8e7-85fb74169dda', 'CREATED', 'c98ba512-33fd-4d13-aa71-a2e6e20d7d45', '2021-01-01 00:03:00');
INSERT INTO "order" (id, "status", client_id, scheduled) VALUES ('2141f61e-f0b3-4197-909d-5c6ca98dae37', 'CREATED', 'c98ba512-33fd-4d13-aa71-a2e6e20d7d45', '2021-01-01 00:03:00');

END
$$;