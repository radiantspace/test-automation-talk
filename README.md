What?
=====
Example code from my "Test Automation" talk. There's some Ruby unit test using RSpec, some Cucumber
unit testing, and WebDriver test.

Before running the presentation
===============================
- Reset this repository.
- Start Sinatra server from browser example.

Ruby example
------------
Run tests: `bundle exec rspec`

Potential code:

```ruby
class Order
  def initialize
    @sum = 0
  end

  def sum
    @sum
  end

  def add_line(description, amount)
    @sum += amount
  end
end
```

Potential test:

```ruby
require 'order'

RSpec.describe Order do
  subject { Order.new }

  context 'newly created' do
    it 'is free' do
      expect(subject.sum).to eq(0)
    end
  end

  context 'with lines' do
    before do
      subject.add_line('Carpets', 42)
      subject.add_line('Cleaners', 15)
    end

    it 'knows the sum' do
      expect(subject.sum).to eq(57)
    end
  end
end
```

Run continuously in RubyMine by right-clicking the `specs` folder, selecting `Run` -> `All specs`, then
selecting the "Toggle auto-test" button just beneath the "play" button to the left.

JavaScript example
------------------
Just load the `index.html` file, reload to re-test. Try breaking the test.

Cucumber example
----------------
Look at the project structure. I already created the `Order` class, so we'll be focusing entirely on the
Cucumber part of it.

Run the tests (`bundle exec cucumber`), watch the really nice and helpful error message appear.

Potential steps:

```ruby
Given('I have an order') do
  @order = Order.new
end

Then('I need to pay {int} dollars') do |int|
  if @order.sum != int
    raise "Expected to pay #{int} dollars, was #{@order.sum}"
  end
end

Given('I add for {int} dollars {string}') do |amount, name|
  @order.add_line(name, amount)
end
```

Browser example
---------------
Install [ChromeDriver](http://chromedriver.storage.googleapis.com/index.html), make sure to put it in `PATH`.

Start server: `bundle exec ruby server.rb`

Run tests: `bundle exec rspec`

Potential test:

```ruby
  it 'can add new tasks' do
    fill_in 'name', with: 'Sleep'
    click_button 'Add'

    fill_in 'name', with: 'Wake up'
    click_button 'Add'

    expect(body).to include('Sleep')
    expect(body).to include('Wake up')
  end
```

In `spec_helper.rb`, try setting `Capybara.default_driver` to `:selenium_chrome_headless`.
