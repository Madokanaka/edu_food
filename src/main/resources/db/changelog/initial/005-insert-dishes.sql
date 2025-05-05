-- === La Trattoria ===
INSERT INTO dishes (name, description, price, restaurant_id) VALUES
('Паста Карбонара', 'Классическая паста с беконом и сливочным соусом', 650.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Пицца Маргарита', 'Пицца с моцареллой, томатами и базиликом', 550.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Ризотто с грибами', 'Кремовое ризотто с белыми грибами', 700.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Брускетта', 'Хлеб с томатами и базиликом', 300.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Лазанья', 'Слоеное блюдо из пасты, мяса и соуса бешамель', 750.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Тирамису', 'Кофейный десерт с маскарпоне', 450.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Минестроне', 'Овощной суп с пастой', 400.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Капрезе', 'Салат из моцареллы, томатов и базилика', 420.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Фокачча', 'Итальянский хлеб с розмарином', 250.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria')),
('Панна Котта', 'Десерт со сливками и ванилью', 430.00, (SELECT id FROM restaurants WHERE name = 'La Trattoria'));

-- === Sushi Bar Tokyo ===
INSERT INTO dishes (name, description, price, restaurant_id) VALUES
('Суши с лососем', 'Свежий лосось на рисе с васаби', 300.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Ролл Калифорния', 'Рис, краб, авокадо и огурец', 450.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Сашими тунец', 'Нарезка свежего тунца', 500.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Темпура', 'Овощи и морепродукты в кляре', 470.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Мисо суп', 'Традиционный японский суп с тофу и водорослями', 220.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Гедза', 'Жареные пельмени с мясом', 350.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Соба', 'Лапша из гречневой муки', 330.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Ролл Филадельфия', 'С лососем и сыром', 460.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Салат с водорослями', 'Маринованные водоросли с кунжутом', 290.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo')),
('Якинику', 'Жареное мясо на гриле', 580.00, (SELECT id FROM restaurants WHERE name = 'Sushi Bar Tokyo'));

-- === Bistro Parisien ===
INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Киш Лорен', 'Французский пирог с беконом и сыром', 500.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Французский луковый суп', 'Классический суп с гренками и сыром', 420.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Конфи из утки', 'Утиное бедро, томленое в утином жире', 800.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Круассан', 'Свежевыпеченный слоеный круассан', 200.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Рататуй', 'Овощное блюдо из прованса', 450.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Тар-тар из говядины', 'Сырой фарш с пряностями', 650.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Бёф Бургиньон', 'Говядина, тушенная в вине', 780.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Крем-брюле', 'Французский заварной десерт', 350.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Салат Нисуаз', 'С тунцом, яйцом и оливками', 490.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien')),
                                                                 ('Мильфей', 'Слоеный пирог с кремом', 430.00, (SELECT id FROM restaurants WHERE name = 'Bistro Parisien'));

-- === Steak House Grill ===
INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Рибай стейк', 'Мраморная говядина на гриле', 1100.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Стейк Нью-Йорк', 'Отруб с минимумом жира', 980.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Картофель фри', 'Классический гарнир', 250.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Кукуруза на гриле', 'Сочная кукуруза с маслом', 270.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Салат коул-слоу', 'Капустный салат с морковью и соусом', 230.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Бургер с говядиной', 'Сочный бургер с соусами и овощами', 560.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Томатный суп с беконом', 'Подается с чесночными гренками', 350.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Гриль-сет', 'Набор мясных деликатесов', 1450.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Соус BBQ', 'Подается к мясным блюдам', 100.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill')),
                                                                 ('Шоколадный брауни', 'Теплый десерт с мороженым', 380.00, (SELECT id FROM restaurants WHERE name = 'Steak House Grill'));

-- === Taco Loco ===
INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Тако с говядиной', 'Мясо с острым соусом в кукурузной лепешке', 290.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Буррито с курицей', 'Рис, фасоль, курица и сыр', 420.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Начос с сыром', 'Кукурузные чипсы с плавленым сыром', 310.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Фахитас с говядиной', 'Жареное мясо с овощами', 510.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Сальса', 'Острый томатный соус', 120.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Гуакамоле', 'Пюре из авокадо с лаймом и специями', 180.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Чуррос', 'Жареное тесто с сахаром и корицей', 250.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Тостада', 'Хрустящая лепешка с начинкой', 330.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Энчилада', 'Запеченная лепешка с мясом и сыром', 460.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco')),
                                                                 ('Маргарита', 'Коктейль с текилой и лаймом', 350.00, (SELECT id FROM restaurants WHERE name = 'Taco Loco'));

INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Утка по-пекински', 'Классическая утка с хрустящей корочкой и блинами', 1200.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Жареные пельмени', 'С хрустящей корочкой и сочной начинкой', 390.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Суп Том Ям', 'Острый суп с морепродуктами', 450.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Курица кунг пао', 'С арахисом и перцем чили', 520.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Спринг роллы', 'Овощные или мясные роллы', 300.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Жареный рис с овощами', 'Ароматный рис с соусом', 350.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Говядина в кисло-сладком соусе', 'Классика китайской кухни', 580.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Сяо лун бао', 'Суповые пельмени на пару', 400.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Жареная лапша с говядиной', 'С овощами и соевым соусом', 470.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House')),
                                                                 ('Чай улун', 'Ароматный китайский чай', 180.00, (SELECT id FROM restaurants WHERE name = 'Peking Duck House'));

INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Салат с киноа', 'Киноа, авокадо и овощи', 420.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Тофу в соусе терияки', 'Жареный тофу с овощами', 390.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Веганский бургер', 'Котлета из нута с соусом', 480.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Смузи из манго и банана', 'Свежий фруктовый напиток', 320.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Овощной боул', 'Овощи, киноа, авокадо, хумус', 510.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Паста с соусом песто', 'Паста без яиц, песто из базилика', 440.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Веганское мороженое', 'Кокосовое молоко и ягоды', 270.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Лапша удон с овощами', 'Японская лапша с овощами и тофу', 390.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Суп из чечевицы', 'Насыщенный и сытный суп', 350.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner')),
                                                                 ('Веганская пицца', 'Тесто без яиц, овощи, веган-сыр', 520.00, (SELECT id FROM restaurants WHERE name = 'The Vegan Corner'));

INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Феттучини с грибами', 'Паста с белыми грибами и сливочным соусом', 490.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Тальятелле болоньезе', 'Паста с мясным соусом', 520.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Паппарделле с уткой', 'Паста с уткой в вине', 580.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Равиоли с сыром рикотта', 'Подаются с томатным соусом', 470.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Лазанья', 'Классическая мясная лазанья', 510.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Спагетти карбонара', 'Сливочный соус и бекон', 500.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Пенне арабьята', 'Пикантный томатный соус', 460.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Гнокки с соусом песто', 'Картофельные клецки с базиликом', 430.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Тортеллини с мясом', 'Мясная начинка и сливочный соус', 550.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca')),
                                                                 ('Брускетта', 'Гренки с томатами и базиликом', 290.00, (SELECT id FROM restaurants WHERE name = 'Pasta Fresca'));

INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Пицца Маргарита', 'Сыр моцарелла, соус и базилик', 430.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Пицца Пепперони', 'Острая колбаска и сыр', 470.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Пицца 4 сыра', 'Моцарелла, горгонзола, пармезан, эмменталь', 490.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Пицца с морепродуктами', 'Креветки, кальмары и мидии', 550.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Пицца с ветчиной и грибами', 'Классическое сочетание', 460.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Кальцоне', 'Закрытая пицца с мясной начинкой', 510.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Тирамису', 'Десерт с маскарпоне и кофе', 340.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Панна-котта', 'Десерт с ванилью и ягодами', 320.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Минестроне', 'Итальянский овощной суп', 380.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!')),
                                                                 ('Капрезе', 'Моцарелла, томаты, базилик', 350.00, (SELECT id FROM restaurants WHERE name = 'Mamma Mia!'));

INSERT INTO dishes (name, description, price, restaurant_id) VALUES
                                                                 ('Круассан с маслом', 'Классический французский круассан', 180.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Эклер с шоколадом', 'Французский десерт с кремом', 220.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Миндальное печенье', 'Французское печенье макарун', 250.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Кофе латте', 'Свежеобжаренный кофе с молоком', 200.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Чай с бергамотом', 'Классический черный чай', 150.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Багет с сыром', 'Свежий багет с мягким сыром', 280.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Салат с козьим сыром', 'Легкий салат с орехами и сыром', 360.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Омлет с зеленью', 'Французский завтрак', 300.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Французский тост', 'Сладкий хлеб с сиропом', 270.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café')),
                                                                 ('Тарт Татен', 'Перевернутый яблочный пирог', 330.00, (SELECT id FROM restaurants WHERE name = 'Le Petit Café'));

