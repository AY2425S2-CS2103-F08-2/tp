
    var pageVueRenderFn = function noop (a, b, c) {};
    var pageVueStaticRenderFns = [function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"acknowledgements"}},[_c('strong',[_v("Acknowledgements")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#acknowledgements","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',{attrs:{"list":"","here":"","sources":"","of":"","all":"","reusedadapted":"","ideas,":"","code,":"","documentation,":"","and":"","third-party":"","libraries":"","--":"","include":"","links":"","to":"","the":"","original":"","source":"","as":"","well":""}})])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"setting-up-getting-started"}},[_c('strong',[_v("Setting up, getting started")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#setting-up-getting-started","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("Refer to the guide "),_c('a',{attrs:{"href":"/tp/docs/SettingUp.html"}},[_c('em',[_v("Setting up and getting started")])]),_v(".")])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"design"}},[_c('strong',[_v("Design")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#design","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('div',{staticClass:"alert alert-primary",attrs:{"markdown":"span"}},[_c('p',[_v("💡 "),_c('strong',[_v("Tip:")]),_v(" The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v(".puml")]),_v(" files used to create diagrams in this document "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("docs/diagrams")]),_v(" folder. Refer to the "),_c('a',{attrs:{"href":"https://se-education.org/guides/tutorials/plantUml.html"}},[_c('em',[_v("PlantUML Tutorial")]),_v(" at se-edu/guides")]),_v(" to learn how to create and edit diagrams.")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"architecture"}},[_v("Architecture"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#architecture","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('em',[_c('strong',[_v("Architecture Diagram")])]),_v(" given above explains the high-level design of the App.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Main components of the architecture")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Main")])]),_v(" (consisting of classes "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Main")])]),_v(" and "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainApp")])]),_v(") is in charge of the app launch and shut down.")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("At app launch, it initializes the other components in the correct sequence, and connects them up with each other.")]),_v(" "),_c('li',[_v("At shut down, it shuts down the other components and invokes cleanup methods where necessary.")])])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('a',{attrs:{"href":"#ui-component"}},[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UI")])])]),_v(": The UI of the App.")]),_v(" "),_c('li',[_c('a',{attrs:{"href":"#logic-component"}},[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")])])]),_v(": The command executor.")]),_v(" "),_c('li',[_c('a',{attrs:{"href":"#model-component"}},[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")])])]),_v(": Holds the data of the App in memory.")]),_v(" "),_c('li',[_c('a',{attrs:{"href":"#storage-component"}},[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Storage")])])]),_v(": Reads data from, and writes data to, the hard disk.")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"#common-classes"}},[_c('strong',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Commons")])])]),_v(" represents a collection of classes used by multiple other components.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("How the architecture components interact with each other")])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('em',[_v("Sequence Diagram")]),_v(" below shows how the components interact with each other for the scenario where the user issues the command "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete 1")]),_v(".")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("defines its "),_c('em',[_v("API")]),_v(" in an "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("interface")]),_v(" with the same name as the Component.")]),_v(" "),_c('li',[_v("implements its functionality using a concrete "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("{Component Name}Manager")]),_v(" class (which follows the corresponding API "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("interface")]),_v(" mentioned in the previous point.")])])}
},function anonymous(
) {
with(this){return _c('p',[_v("For example, the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component defines its API in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic.java")]),_v(" interface and implements its functionality using the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("LogicManager.java")]),_v(" class which follows the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.")])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"ui-component"}},[_v("UI component"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#ui-component","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('strong',[_v("API")]),_v(" of this component is specified in "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Ui.java")])])])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UiClassDiagram.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UiClassDiagram.png","alt":"Structure of the UI Component"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The UI consists of a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainWindow")]),_v(" that is made up of parts e.g."),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("CommandBox")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("ResultDisplay")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("PersonListPanel")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("StatusBarFooter")]),_v(" etc. All these, including the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainWindow")]),_v(", inherit from the abstract "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UiPart")]),_v(" class which captures the commonalities between classes that represent parts of the visible GUI.")])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UI")]),_v(" component uses the JavaFx UI framework. The layout of these UI parts are defined in matching "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v(".fxml")]),_v(" files that are in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("src/main/resources/view")]),_v(" folder. For example, the layout of the "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainWindow")])]),_v(" is specified in "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("MainWindow.fxml")])])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UI")]),_v(" component,")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("executes user commands using the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component.")]),_v(" "),_c('li',[_v("listens for changes to "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" data so that the UI can be updated with the modified data.")]),_v(" "),_c('li',[_v("keeps a reference to the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component, because the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UI")]),_v(" relies on the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" to execute commands.")]),_v(" "),_c('li',[_v("depends on some classes in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" component, as it displays "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Person")]),_v(" object residing in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(".")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"logic-component"}},[_v("Logic component"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#logic-component","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("API")]),_v(" : "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic.java")])])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Here's a (partial) class diagram of the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component:")])}
},function anonymous(
) {
with(this){return _c('p',[_v("The sequence diagram below illustrates the interactions within the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component, taking "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("execute(\"delete 1\")")]),_v(" API call as an example.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/DeleteSequenceDiagram.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/DeleteSequenceDiagram.png","alt":"Interactions Inside the Logic Component for the `delete 1` Command"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("How the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component works:")])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_v("When "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" is called upon to execute a command, it is passed to an "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBookParser")]),_v(" object which in turn creates a parser that matches the command (e.g., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("DeleteCommandParser")]),_v(") and uses it to parse the command.")]),_v(" "),_c('li',[_v("This results in a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Command")]),_v(" object (more precisely, an object of one of its subclasses e.g., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("DeleteCommand")]),_v(") which is executed by the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("LogicManager")]),_v(".")]),_v(" "),_c('li',[_v("The command can communicate with the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" when it is executed (e.g. to delete a person)."),_c('br'),_v("\nNote that although this is shown as a single step in the diagram above (for simplicity), in the code it can take several interactions (between the command object and the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(") to achieve.")]),_v(" "),_c('li',[_v("The result of the command execution is encapsulated as a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("CommandResult")]),_v(" object which is returned back from "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(".")])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Here are the other classes in "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" (omitted from the class diagram above) that are used for parsing a user command:")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("When called upon to parse a user command, the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBookParser")]),_v(" class creates an "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("XYZCommandParser")]),_v(" ("),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("XYZ")]),_v(" is a placeholder for the specific command name e.g., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddCommandParser")]),_v(") which uses the other classes shown above to parse the user command and create a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("XYZCommand")]),_v(" object (e.g., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddCommand")]),_v(") which the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBookParser")]),_v(" returns back as a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Command")]),_v(" object.")]),_v(" "),_c('li',[_v("All "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("XYZCommandParser")]),_v(" classes (e.g., "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddCommandParser")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("DeleteCommandParser")]),_v(", ...) inherit from the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Parser")]),_v(" interface so that they can be treated similarly where possible e.g, during testing.")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"model-component"}},[_v("Model component"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#model-component","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("API")]),_v(" : "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model.java")])])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" component,")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("stores the address book data i.e., all "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Person")]),_v(" objects (which are contained in a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UniquePersonList")]),_v(" object).")]),_v(" "),_c('li',[_v("stores the currently 'selected' "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Person")]),_v(" objects (e.g., results of a search query) as a separate "),_c('em',[_v("filtered")]),_v(" list which is exposed to outsiders as an unmodifiable "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("ObservableList<Person>")]),_v(" that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.")]),_v(" "),_c('li',[_v("stores a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UserPref")]),_v(" object that represents the user’s preferences. This is exposed to the outside as a "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("ReadOnlyUserPref")]),_v(" objects.")]),_v(" "),_c('li',[_v("does not depend on any of the other three components (as the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" represents data entities of the domain, they should make sense on their own without depending on other components)")])])}
},function anonymous(
) {
with(this){return _c('div',{staticClass:"alert alert-info",attrs:{"markdown":"span"}},[_v(":information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects."),_c('br'),_v(" "),_c('img',{attrs:{"src":"/tp/docs/images/BetterModelClassDiagram.png","width":"450"}})])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"storage-component"}},[_v("Storage component"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#storage-component","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("API")]),_v(" : "),_c('a',{attrs:{"href":"https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java"}},[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Storage.java")])])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Storage")]),_v(" component,")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("can save both address book data and user preference data in JSON format, and read them back into corresponding objects.")]),_v(" "),_c('li',[_v("inherits from both "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBookStorage")]),_v(" and "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("UserPrefStorage")]),_v(", which means it can be treated as either one (if only the functionality of only one is needed).")]),_v(" "),_c('li',[_v("depends on some classes in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" component (because the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Storage")]),_v(" component's job is to save/retrieve objects that belong to the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(")")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"common-classes"}},[_v("Common classes"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#common-classes","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("Classes used by multiple components are in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("seedu.address.commons")]),_v(" package.")])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"implementation"}},[_c('strong',[_v("Implementation")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#implementation","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"proposed-undo-redo-feature"}},[_v("[Proposed] Undo/redo feature"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#proposed-undo-redo-feature","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('h4',{attrs:{"id":"proposed-implementation"}},[_v("Proposed Implementation"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#proposed-implementation","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("The proposed undo/redo mechanism is facilitated by "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("VersionedAddressBook")]),_v(". It extends "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBook")]),_v(" with an undo/redo history, stored internally as an "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("addressBookStateList")]),_v(" and "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(". Additionally, it implements the following operations:")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("VersionedAddressBook#commit()")]),_v(" — Saves the current address book state in its history.")]),_v(" "),_c('li',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("VersionedAddressBook#undo()")]),_v(" — Restores the previous address book state from its history.")]),_v(" "),_c('li',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("VersionedAddressBook#redo()")]),_v(" — Restores a previously undone address book state from its history.")])])}
},function anonymous(
) {
with(this){return _c('p',[_v("These operations are exposed in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" interface as "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#commitAddressBook()")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#undoAddressBook()")]),_v(" and "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#redoAddressBook()")]),_v(" respectively.")])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 1. The user launches the application for the first time. The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("VersionedAddressBook")]),_v(" will be initialized with the initial address book state, and the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" pointing to that single address book state.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState0.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState0.png","alt":"UndoRedoState0"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 2. The user executes "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete 5")]),_v(" command to delete the 5th person in the address book. The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete")]),_v(" command calls "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#commitAddressBook()")]),_v(", causing the modified state of the address book after the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete 5")]),_v(" command executes to be saved in the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("addressBookStateList")]),_v(", and the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" is shifted to the newly inserted address book state.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState1.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState1.png","alt":"UndoRedoState1"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 3. The user executes "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("add n/David …​")]),_v(" to add a new person. The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("add")]),_v(" command also calls "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#commitAddressBook()")]),_v(", causing another modified address book state to be saved into the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("addressBookStateList")]),_v(".")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState2.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState2.png","alt":"UndoRedoState2"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("undo")]),_v(" command. The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("undo")]),_v(" command will call "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#undoAddressBook()")]),_v(", which will shift the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" once to the left, pointing it to the previous address book state, and restores the address book to that state.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState3.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState3.png","alt":"UndoRedoState3"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The following sequence diagram shows how an undo operation goes through the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Logic")]),_v(" component:")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoSequenceDiagram-Logic.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoSequenceDiagram-Logic.png","alt":"UndoSequenceDiagram"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Similarly, how an undo operation goes through the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model")]),_v(" component is shown below:")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoSequenceDiagram-Model.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoSequenceDiagram-Model.png","alt":"UndoSequenceDiagram"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("The "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("redo")]),_v(" command does the opposite — it calls "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#redoAddressBook()")]),_v(", which shifts the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" once to the right, pointing to the previously undone state, and restores the address book to that state.")])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 5. The user then decides to execute the command "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("list")]),_v(". Commands that do not modify the address book, such as "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("list")]),_v(", will usually not call "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#commitAddressBook()")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#undoAddressBook()")]),_v(" or "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#redoAddressBook()")]),_v(". Thus, the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("addressBookStateList")]),_v(" remains unchanged.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState4.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState4.png","alt":"UndoRedoState4"}})])])}
},function anonymous(
) {
with(this){return _c('p',[_v("Step 6. The user executes "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("clear")]),_v(", which calls "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("Model#commitAddressBook()")]),_v(". Since the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" is not pointing at the end of the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("addressBookStateList")]),_v(", all address book states after the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("currentStatePointer")]),_v(" will be purged. Reason: It no longer makes sense to redo the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("add n/David …​")]),_v(" command. This is the behavior that most modern desktop applications follow.")])}
},function anonymous(
) {
with(this){return _c('p',[_c('a',{attrs:{"href":"/tp/docs/images/UndoRedoState5.png","target":"_self"}},[_c('img',{staticClass:"img-fluid",attrs:{"src":"/tp/docs/images/UndoRedoState5.png","alt":"UndoRedoState5"}})])])}
},function anonymous(
) {
with(this){return _c('h4',{attrs:{"id":"design-considerations"}},[_v("Design considerations:"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#design-considerations","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Aspect: How undo & redo executes:")])])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('p',[_c('strong',[_v("Alternative 1 (current choice):")]),_v(" Saves the entire address book.")]),_v(" "),_c('ul',[_c('li',[_v("Pros: Easy to implement.")]),_v(" "),_c('li',[_v("Cons: May have performance issues in terms of memory usage.")])])]),_v(" "),_c('li',[_c('p',[_c('strong',[_v("Alternative 2:")]),_v(" Individual command knows how to undo/redo by\nitself.")]),_v(" "),_c('ul',[_c('li',[_v("Pros: Will use less memory (e.g. for "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete")]),_v(", just save the person being deleted).")]),_v(" "),_c('li',[_v("Cons: We must ensure that the implementation of each individual command are correct.")])])])])}
},function anonymous(
) {
with(this){return _c('p',[_c('em',[_v("{more aspects and alternatives to be added}")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"proposed-data-archiving"}},[_v("[Proposed] Data archiving"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#proposed-data-archiving","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('em',[_v("{Explain here how the data archiving feature will be implemented}")])])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"documentation-logging-testing-configuration-dev-ops"}},[_c('strong',[_v("Documentation, logging, testing, configuration, dev-ops")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#documentation-logging-testing-configuration-dev-ops","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('a',{attrs:{"href":"/tp/docs/Documentation.html"}},[_v("Documentation guide")])]),_v(" "),_c('li',[_c('a',{attrs:{"href":"/tp/docs/Testing.html"}},[_v("Testing guide")])]),_v(" "),_c('li',[_c('a',{attrs:{"href":"/tp/docs/Logging.html"}},[_v("Logging guide")])]),_v(" "),_c('li',[_c('a',{attrs:{"href":"/tp/docs/Configuration.html"}},[_v("Configuration guide")])]),_v(" "),_c('li',[_c('a',{attrs:{"href":"/tp/docs/DevOps.html"}},[_v("DevOps guide")])])])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"appendix-requirements"}},[_c('strong',[_v("Appendix: Requirements")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#appendix-requirements","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"product-scope"}},[_v("Product scope"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#product-scope","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Target user profile")]),_v(":")])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_v("has a need to manage a significant number of contacts")]),_v(" "),_c('li',[_v("prefer desktop apps over other types")]),_v(" "),_c('li',[_v("can type fast")]),_v(" "),_c('li',[_v("prefers typing to mouse interactions")]),_v(" "),_c('li',[_v("is reasonably comfortable using CLI apps")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Value proposition")]),_v(": manage contacts faster than a typical mouse/GUI driven app")])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"user-stories"}},[_v("User stories"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#user-stories","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("Priorities: High (must have) - "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* * *")]),_v(", Medium (nice to have) - "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* *")]),_v(", Low (unlikely to have) - "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("*")])])}
},function anonymous(
) {
with(this){return _c('div',{staticClass:"table-responsive"},[_c('table',{staticClass:"markbind-table table table-bordered table-striped"},[_c('thead',[_c('tr',[_c('th',[_v("Priority")]),_v(" "),_c('th',[_v("As a …​")]),_v(" "),_c('th',[_v("I want to …​")]),_v(" "),_c('th',[_v("So that I can…​")])])]),_v(" "),_c('tbody',[_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* * *")])]),_v(" "),_c('td',[_v("new user")]),_v(" "),_c('td',[_v("see usage instructions")]),_v(" "),_c('td',[_v("refer to instructions when I forget how to use the App")])]),_v(" "),_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* * *")])]),_v(" "),_c('td',[_v("user")]),_v(" "),_c('td',[_v("add a new person")]),_v(" "),_c('td')]),_v(" "),_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* * *")])]),_v(" "),_c('td',[_v("user")]),_v(" "),_c('td',[_v("delete a person")]),_v(" "),_c('td',[_v("remove entries that I no longer need")])]),_v(" "),_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* * *")])]),_v(" "),_c('td',[_v("user")]),_v(" "),_c('td',[_v("find a person by name")]),_v(" "),_c('td',[_v("locate details of persons without having to go through the entire list")])]),_v(" "),_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("* *")])]),_v(" "),_c('td',[_v("user")]),_v(" "),_c('td',[_v("hide private contact details")]),_v(" "),_c('td',[_v("minimize chance of someone else seeing them by accident")])]),_v(" "),_c('tr',[_c('td',[_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("*")])]),_v(" "),_c('td',[_v("user with many persons in the address book")]),_v(" "),_c('td',[_v("sort persons by name")]),_v(" "),_c('td',[_v("locate a person easily")])])])])])}
},function anonymous(
) {
with(this){return _c('p',[_c('em',[_v("{More to be added}")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"use-cases"}},[_v("Use cases"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#use-cases","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('p',[_v("(For all use cases below, the "),_c('strong',[_v("System")]),_v(" is the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("AddressBook")]),_v(" and the "),_c('strong',[_v("Actor")]),_v(" is the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("user")]),_v(", unless specified otherwise)")])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Use case: Delete a person")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("MSS")])])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_c('p',[_v("User requests to list persons")])]),_v(" "),_c('li',[_c('p',[_v("AddressBook shows a list of persons")])]),_v(" "),_c('li',[_c('p',[_v("User requests to delete a specific person in the list")])]),_v(" "),_c('li',[_c('p',[_v("AddressBook deletes the person")]),_v(" "),_c('p',[_v("Use case ends.")])])])}
},function anonymous(
) {
with(this){return _c('p',[_c('strong',[_v("Extensions")])])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('p',[_v("2a. The list is empty.")]),_v(" "),_c('p',[_v("Use case ends.")])]),_v(" "),_c('li',[_c('p',[_v("3a. The given index is invalid.")]),_v(" "),_c('ul',[_c('li',[_c('p',[_v("3a1. AddressBook shows an error message.")]),_v(" "),_c('p',[_v("Use case resumes at step 2.")])])])])])}
},function anonymous(
) {
with(this){return _c('p',[_c('em',[_v("{More to be added}")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"non-functional-requirements"}},[_v("Non-Functional Requirements"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#non-functional-requirements","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_v("Should work on any "),_c('em',[_v("mainstream OS")]),_v(" as long as it has Java "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("17")]),_v(" or above installed.")]),_v(" "),_c('li',[_v("Should be able to hold up to 1000 persons without a noticeable sluggishness in performance for typical usage.")]),_v(" "),_c('li',[_v("A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.")])])}
},function anonymous(
) {
with(this){return _c('p',[_c('em',[_v("{More to be added}")])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"glossary"}},[_v("Glossary"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#glossary","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ul',[_c('li',[_c('strong',[_v("Mainstream OS")]),_v(": Windows, Linux, Unix, MacOS")]),_v(" "),_c('li',[_c('strong',[_v("Private contact detail")]),_v(": A contact detail that is not meant to be shared with others")])])}
},function anonymous(
) {
with(this){return _c('h2',{attrs:{"id":"appendix-instructions-for-manual-testing"}},[_c('strong',[_v("Appendix: Instructions for manual testing")]),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#appendix-instructions-for-manual-testing","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"launch-and-shutdown"}},[_v("Launch and shutdown"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#launch-and-shutdown","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_c('p',[_v("Initial launch")]),_v(" "),_c('ol',[_c('li',[_c('p',[_v("Download the jar file and copy into an empty folder")])]),_v(" "),_c('li',[_c('p',[_v("Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.")])])])]),_v(" "),_c('li',[_c('p',[_v("Saving window preferences")]),_v(" "),_c('ol',[_c('li',[_c('p',[_v("Resize the window to an optimum size. Move the window to a different location. Close the window.")])]),_v(" "),_c('li',[_c('p',[_v("Re-launch the app by double-clicking the jar file."),_c('br'),_v("\nExpected: The most recent window size and location is retained.")])])])]),_v(" "),_c('li',[_c('p',[_c('em',[_v("{ more test cases …​ }")])])])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"deleting-a-person"}},[_v("Deleting a person"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#deleting-a-person","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_c('p',[_v("Deleting a person while all persons are being shown")]),_v(" "),_c('ol',[_c('li',[_c('p',[_v("Prerequisites: List all persons using the "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("list")]),_v(" command. Multiple persons in the list.")])]),_v(" "),_c('li',[_c('p',[_v("Test case: "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete 1")]),_c('br'),_v("\nExpected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.")])]),_v(" "),_c('li',[_c('p',[_v("Test case: "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete 0")]),_c('br'),_v("\nExpected: No person is deleted. Error details shown in the status message. Status bar remains the same.")])]),_v(" "),_c('li',[_c('p',[_v("Other incorrect delete commands to try: "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("delete x")]),_v(", "),_c('code',{pre:true,attrs:{"class":"hljs inline no-lang"}},[_v("...")]),_v(" (where x is larger than the list size)"),_c('br'),_v("\nExpected: Similar to previous.")])])])]),_v(" "),_c('li',[_c('p',[_c('em',[_v("{ more test cases …​ }")])])])])}
},function anonymous(
) {
with(this){return _c('h3',{attrs:{"id":"saving-data"}},[_v("Saving data"),_c('a',{staticClass:"fa fa-anchor",attrs:{"href":"#saving-data","onclick":"event.stopPropagation()"}})])}
},function anonymous(
) {
with(this){return _c('ol',[_c('li',[_c('p',[_v("Dealing with missing/corrupted data files")]),_v(" "),_c('ol',[_c('li',[_c('em',[_v("{explain how to simulate a missing/corrupted file, and the expected behavior}")])])])]),_v(" "),_c('li',[_c('p',[_c('em',[_v("{ more test cases …​ }")])])])])}
}];
  