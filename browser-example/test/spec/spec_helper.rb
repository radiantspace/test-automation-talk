require 'capybara/rspec'
require 'selenium/webdriver'

RSpec.configure do |config|
  Capybara.default_driver = :selenium
  Capybara.app_host = 'http://localhost:4567'
  Capybara.run_server = false

  config.expect_with :rspec do |expectations|
    expectations.include_chain_clauses_in_custom_matcher_descriptions = true
  end

  config.mock_with :rspec do |mocks|
    mocks.verify_partial_doubles = true
  end

  config.shared_context_metadata_behavior = :apply_to_host_groups
end
