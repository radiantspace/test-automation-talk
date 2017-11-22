require 'sinatra'

tasks = ['Aflevere børn', 'Hente børn']

get '/' do
  erb 'index.html'.to_sym, locals: { tasks: tasks }
end

post '/add_task' do
  tasks << params['name']
  redirect '/'
end

post '/clear' do
  tasks = []
  redirect '/'
end
