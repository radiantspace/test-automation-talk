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
Run tests: `bundle exec rspec`. If you want some nice formatting: `bundle exec rspec -f d`.

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

CLI example
-----------
Run tests: `bundle exec rspec`

These tests are using [JetBlack](https://github.com/odlp/jet_black), which has great documentation on GitHub.

Potential test:

```ruby
  context "when starting up for the first time" do
    it "has no items" do
      result = session.run("#{command} list")
      expect(result.stdout).to be_empty
    end

    it "can add an item by specifying it on the command-line" do
      session.run("#{command} add Buy milk")

      result = session.run("#{command} list")
      expect(result.stdout).to include("1. Buy milk")
    end

    it "can add an item by specifying it interactively" do
      session.run_interactive("#{command} add") do |terminal|
        terminal.expect("Which item would you like to add?", reply: "Buy milk")
      end

      result = session.run("#{command} list")
      expect(result.stdout).to include("1. Buy milk")
    end
  end

  context "with a couple of items" do
    before do
      session.run("#{command} add Buy milk")
      session.run("#{command} add Slice bread")
    end

    it "can complete an item by specifying the number on the command-line" do
      session.run("#{command} complete 1")

      result = session.run("#{command} list")
      expect(result.stdout).to include("1. Slice bread")
      expect(result.stdout).not_to include("Buy milk")
    end

    it "can complete an item by specifying the number interactively" do
      session.run_interactive("#{command} complete") do |terminal|
        terminal.expect("Which item would you like to complete?", reply: "1")
      end

      result = session.run("#{command} list")
      expect(result.stdout).to include("1. Slice bread")
      expect(result.stdout).not_to include("Buy milk")
    end
  end
```

Browser example
---------------
Make sure you have Firefox installed.

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

In `spec_helper.rb`, try setting `Capybara.default_driver` to `:selenium_headless`.
