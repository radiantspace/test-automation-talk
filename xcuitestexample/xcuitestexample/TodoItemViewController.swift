import UIKit

class TodoItemViewController : UIViewController {
    @IBOutlet weak var nameTextField: UITextField!
    
    @IBAction func createButtonTouched(_ sender: Any) {
        MainViewController.addItem(name: nameTextField.text!)
        
        navigationController?.popViewController(animated: true)
    }
}
