import UIKit

class MainViewController : UITableViewController {
    static var items: [String] = ["Aflevere børn", "Hente børn"]
    
    static func addItem(name: String) {
        items.append(name)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let item = UIBarButtonItem(barButtonSystemItem: UIBarButtonSystemItem.add, target: self, action: #selector(addNewItem(sender:)))
        navigationItem.setRightBarButton(item, animated: false)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        tableView.reloadData()
    }

    @objc func addNewItem(sender: UIBarButtonItem) {
        performSegue(withIdentifier: "ShowTodoItemSegue", sender: self)
    }
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return MainViewController.items.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell() // That's right. No cell reuse in this tiny app!
        cell.textLabel!.text = MainViewController.items[indexPath.row]
        
        return cell
    }
}
